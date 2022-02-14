package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dao.CurseDao;
import uz.pdp.dto.CourseDto;
import uz.pdp.dto.UserDto;
import uz.pdp.service.CourseService;

import java.util.List;


@Controller
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;


    @Autowired
    CurseDao curseDao;

//    @GetMapping(value = "/show")
//    public String getAllCourses(@RequestParam(required = false, name = "id") Integer id, Model model) {
//        List<CourseDto> allCourses;
//        if (id == null) {
//            allCourses = courseService.getAllCoursesBySubject();
//            model.addAttribute("courseList", allCourses);
//            return "main-jsp/show-main";
//        }
//
//        allCourses = courseService.getAllCourses();
//        model.addAttribute("courseList", allCourses);
//        return "view-courses";
//
//    }


    @GetMapping(value = "/courseSubject/{id}")
    public String showCourseSubject(@PathVariable int id, Model model) {
        CourseDto courseDto = courseService.courseDto(id);
        model.addAttribute("course", courseDto);
        return "edit";
    }


    @GetMapping(value = "/edit/{id}")
    public String editCourses(@PathVariable int id, Model model) {
        CourseDto courseDto = courseService.courseDto(id);
        model.addAttribute("course", courseDto);
        return "edit";
    }


    @GetMapping(value = "/showCurseByIdMain/{id}") // TODO: 2/12/2022  
    public String showCourseMain(@PathVariable int id, Model model) {
        CourseDto courseDto = courseService.courseDtoById(id);
        model.addAttribute("course", courseDto);
        return "show-course";
    }

    @GetMapping(value = "/showCurseById/{id}")
    public String showCourse(@PathVariable int id, Model model) {
        CourseDto courseDto = courseService.courseDtoById(id);
        model.addAttribute("course", courseDto);
        return "show-course";
    }


    @GetMapping(value = "/show")
    public String updateCourses(Model model) {
        List<CourseDto>allCourses = courseService.getAllCourses();
        model.addAttribute("courseList", allCourses);
        return "view-courses";
    }


    @GetMapping("/{id}")
    public String getCourseById(@PathVariable int id) {
        return "view-courses-by-id";
    }


//    @RequestMapping(value = "/edit/{cours}"/*,method = RequestMethod.POST*/)
//    public String editsave(@PathVariable int cours) {
//        System.out.println("keldi");
//        return "redirect:/viewemp";
//    }


    @RequestMapping(value = "/delete/{id}"/*,method = RequestMethod.POST*/)
    public String delete(@PathVariable int id) {
        curseDao.deleteCourse(id);
        return "redirect:/courses/show";
    }

//    @RequestMapping(value="/edit/{cours}"/*,method = RequestMethod.POST*/)
//    public String delete(@PathVariable int cours){
//        System.out.println("keldi");
//        return "redirect:/viewemp";
//    }

    @RequestMapping(value = "/add"/*,method = RequestMethod.POST*/)
    public String add(@ModelAttribute("course") CourseDto course) {

        curseDao.addNewCourse(course);
        return "redirect:/courses/show";
    }


    @RequestMapping(value = "/update")
    public String edit(@ModelAttribute("course") CourseDto course) {

        curseDao.updateCourse(course);
        return "redirect:/courses/show";
    }

}
