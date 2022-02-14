package uz.pdp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import uz.pdp.dto.CourseDto;
import uz.pdp.dto.UserDto;

import java.util.List;

public class UserDao {
    @Autowired
    JdbcTemplate template;


    public UserDto getCourseDto(int id){

        String sqlQuery = "select id, last_name, first_name from users where id = "+id;
        List<UserDto> userDtos= template.query(sqlQuery, (rs, row) -> {
            UserDto courseDto=new UserDto();
            courseDto.setId(rs.getInt(1));
            courseDto.setLastName(rs.getString(2));
            courseDto.setFirstName(rs.getString(3));

            return courseDto;
        });
        return userDtos.get(0);
    }





    public List<UserDto> getAllCourseDto(){

        String sqlQuery = "select id, last_name, first_name from users";
        List<UserDto> userDtos= template.query(sqlQuery, (rs, row) -> {
            UserDto courseDto=new UserDto();
            courseDto.setId(rs.getInt(1));
            courseDto.setLastName(rs.getString(2));
            courseDto.setFirstName(rs.getString(3));

            return courseDto;
        });
        return userDtos;
    }

    public UserDto getUsesDtoById(int id) {
        String query = "select id, last_name, first_name, bio from users where id = " + id;
        return template.queryForObject(query, (rs, rowNum) -> {
            UserDto userDto1 = new UserDto();
            userDto1.setId(rs.getInt(1));
            userDto1.setLastName(rs.getString(2));
            userDto1.setFirstName(rs.getString(3));
            userDto1.setBio(rs.getString(4));
            return userDto1;
        });
    }

    public UserDto getUserDtoByUsername(String username, String password) {
        String query = "select id, last_name, first_name, username, password from users where password = '"+password+"', username = '"+username+"'";
        return template.queryForObject(query, (rs, rowNum) -> {
            UserDto userDto1 = new UserDto();
            userDto1.setId(rs.getInt(1));
            userDto1.setFirstName(rs.getString(3));
            userDto1.setPassword(rs.getString(4));
            userDto1.setPassword(rs.getString(5));

            return userDto1;
        });
    }


    public boolean addUser(UserDto u){
        String query="insert into\n" +
                "    users(\n" +
                "          last_name, \n" +
                "          first_name\n" +
                "          ) values (\n" +
                "                    '"+u.getLastName()+"',\n" +
                "                    '"+u.getFirstName()+"'\n" +
                "                   )";
        template.execute(query);
        return true;
    }

    public boolean deleteUser(int id){
        String query="delete from users where id = "+id;
        template.execute(query);
        return true;
    }

    public boolean updateUser(UserDto u){
        String query="update users\n" +
                "set first_name = '"+u.getFirstName()+"',\n" +
                "    last_name  = '"+u.getLastName()+"'\n" +
                "where id = "+u.getId();
        template.execute(query);
        return true;
    }





}
