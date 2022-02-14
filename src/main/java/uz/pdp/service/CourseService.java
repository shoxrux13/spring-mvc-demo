package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dao.CurseDao;
import uz.pdp.dto.CourseDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CurseDao courseDao;

    public List<CourseDto> getAllCourses(){

        List<CourseDto> courseDtos = courseDao.getAllCourseDto();
        return  courseDtos;
    }


    public List<CourseDto> getAllCoursesBySubject(){

        List<CourseDto> courseDtos = courseDao.getAllCourseDtoBySubject();
        return  courseDtos;
    }

    public CourseDto courseDto(int id){
        return  courseDao.getCourseDto(id);
    }

    public CourseDto courseDtoById(int id){
        return  courseDao.getCourseById(id);
    }





}
