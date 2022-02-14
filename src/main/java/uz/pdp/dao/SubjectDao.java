package uz.pdp.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import uz.pdp.dto.CourseDto;
import uz.pdp.dto.SubjectDto;
import uz.pdp.dto.UserDto;

import java.lang.reflect.Type;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao {
    @Autowired
    JdbcTemplate template;



    public List<SubjectDto> getAllCourseSubject(int courseId) {

        String sqlQuery = "select *\n" +
                "from subject_by_course_id("+courseId+");";
        List<SubjectDto> courseDtoList = template.query(sqlQuery, (rs, row) -> {
            SubjectDto subjectDto = new SubjectDto();
            subjectDto.setId(rs.getInt(1));
            subjectDto.setName(rs.getString(2));
            subjectDto.setCourseName(rs.getString(3));
            subjectDto.setDescription(rs.getString(4));
            return subjectDto;
        });
        return courseDtoList;

    }




}
