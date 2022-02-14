package uz.pdp.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import uz.pdp.dto.CourseDto;
import uz.pdp.dto.UserDto;

import java.lang.reflect.Type;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CurseDao {
    @Autowired
    JdbcTemplate template;

    public int addNewCourse(CourseDto c) {

        if(c.getAuthorId()!=null) {

            String sqlQuery = "insert into courses(name, price, is_active, description)values ('" + c.getName() + "', " + c.getPrice() + ", '" + c.isActive() + "', '"+c.getDescription()+"') returning id";

            int id = template.queryForObject(sqlQuery, (rs, rowNum) -> {
                int id1 = rs.getInt(1);
                return id1;
            });


            int num = 0;

            if (c.getAuthorId() != null) {
                for (int i : c.getAuthorId()) {
                    String query = "insert into\n" +
                            "    courses_users(\n" +
                            "          user_id, course_id\n" +
                            "          ) values (\n" +
                            "                    " + i + ",\n" +
                            "                    " + id + "\n" +
                            "                   )";
                    num = template.update(query);
                }
            }
            return num;
        }return 0;
    }

    public int deleteCourse(int id){
            String sqlQuery = "delete from courses where id = " + id + ";";
            return template.update(sqlQuery);

    }

    public boolean updateCourse(CourseDto c) {

        String sqlQuery = "update courses \n" +
                "set is_active = " + c.isActive() + ", name = '" + c.getName() + "', description = '"+c.getDescription()+"', price = " + c.getPrice() + "\n" +
                "where id = " + c.getId() + ";";

        template.execute(sqlQuery);

        return true;

    }

    public CourseDto getCourseDto(int id) {
        String query = "select id, name, price, is_active, description from courses where id = " + id;
        return template.queryForObject(query, (rs, rowNum) -> {
            CourseDto courseDto1 = new CourseDto();
            courseDto1.setId(rs.getInt(1));
            courseDto1.setName(rs.getString(2));
            courseDto1.setPrice(rs.getDouble(3));
            courseDto1.setActive(rs.getBoolean(4));
            courseDto1.setDescription(rs.getString(5));
            return courseDto1;
        });
    }


    public CourseDto getCourseById(int id) {
        String query = "select *\n" +
                "from get_courses where course_id="+id;
        return template.queryForObject(query, (rs, rowNum) -> {
            CourseDto courseDto1 = new CourseDto();
            courseDto1.setId(rs.getInt(1));
            courseDto1.setName(rs.getString(2));
            courseDto1.setPrice(rs.getDouble(3));
            courseDto1.setActive(rs.getBoolean(4));
            Array authors = rs.getArray(5);
            Type type = new TypeToken<ArrayList<UserDto>>() {
            }.getType();
            List<UserDto> authorList = new Gson().fromJson(authors.toString(), type);
            courseDto1.setAuthor(authorList);
            return courseDto1;
        });
    }





    public List<CourseDto> getCourseByUserId(int userId) {
        String sqlQuery = "select c.id, c.name\n" +
                "from courses c\n" +
                "join courses_users cu on c.id = cu.course_id\n" +
                "join users u on u.id = cu.user_id\n" +
                "where u.id = "+userId+"\n" +
                "group by u.first_name, c.id;";

        List<CourseDto> courseDtoList = template.query(sqlQuery, (rs, row) -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(rs.getInt(1));
            courseDto.setName(rs.getString(2));
            return courseDto;
        });
        return courseDtoList;

    }





    public List<CourseDto> getAllCourseDto() {

        String sqlQuery = "select *\n" +
                "from get_courses;";
        List<CourseDto> courseDtoList = template.query(sqlQuery, (rs, row) -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(rs.getInt(1));
            courseDto.setName(rs.getString(2));
            courseDto.setPrice(rs.getDouble(3));
            courseDto.setActive(rs.getBoolean(4));
            Array authors = rs.getArray("authors");
            Type type = new TypeToken<ArrayList<UserDto>>() {
            }.getType();
            List<UserDto> authorList = new Gson().fromJson(authors.toString(), type);
            courseDto.setAuthor(authorList);
            return courseDto;
        });
        return courseDtoList;

    }

    public List<CourseDto> getAllCourseDtoBySubject() {

        String sqlQuery = "select c.id, c.name\n" +
                "from subject s\n" +
                "         join courses c on c.id = s.course_id\n" +
                "group by c.id, c.name;";
        List<CourseDto> courseDtoList = template.query(sqlQuery, (rs, row) -> {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(rs.getInt(1));
            courseDto.setName(rs.getString(2));
            return courseDto;
        });
        return courseDtoList;

    }


}
