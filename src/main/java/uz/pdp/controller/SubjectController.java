package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.dto.CourseDto;
import uz.pdp.dto.SubjectDto;
import uz.pdp.service.SubjectService;

import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;


    @GetMapping(value = "/courseSubject/{id}")
    public String showCourseSubject(@PathVariable int id, Model model) {
        List<SubjectDto> subjectDtoList = subjectService.getSubjectByCourseId(id);
        model.addAttribute("subjects", subjectDtoList);
        return "vertical-navbar/navbar";
    }
}
