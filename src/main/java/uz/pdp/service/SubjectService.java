package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dao.SubjectDao;
import uz.pdp.dto.SubjectDto;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectDao subjectDao;


    public List<SubjectDto> getSubjectByCourseId(int courseId){
        return subjectDao.getAllCourseSubject(courseId);
    }
}
