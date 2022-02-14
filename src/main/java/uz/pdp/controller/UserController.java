package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.dao.UserDao;
import uz.pdp.dto.CourseDto;
import uz.pdp.dto.UserDto;
import uz.pdp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;

    @GetMapping(value = "/show")
    public String getAllCourses( Model model) {

            List<UserDto> allUsers = userService.userDtoList();
            model.addAttribute("userList", allUsers);
            return "user-jsp/view-users";

    }

    @GetMapping(value = "/show/{id}")
    public String getUser(@PathVariable int id, Model model) {

            List<CourseDto> courseByUserIdDao = userService.courseDtoByUserId(id);
            UserDto userDto = userService.userDtoById(id);
            model.addAttribute("user", userDto);
            model.addAttribute("courses", courseByUserIdDao);
            return "user-jsp/show-user";
    }

    @GetMapping(value = "/login")
    public String login(@ModelAttribute UserDto userDto, Model model) {
        UserDto userDto1 = userService.getUserByUsername(userDto.getUsername(), userDto.getPassword());


        if(userDto1!=null){
            HttpServletRequest req = null;

            HttpSession session = req.getSession();
            session.setAttribute("username", userDto1.getUsername());

            // TODO: 2/12/2022 LOGIN


        }


        return "user-jsp/show-user";
    }



    @GetMapping(value = "/adduser")
    public String addUser(Model model) {
        List<UserDto> allUsers = userService.userDtoList();
        model.addAttribute("userList", allUsers);
        return "add";
    }


    @GetMapping(value = "/edit/{id}")
    public String updateUser(Model model, @PathVariable int id) {
        UserDto users = userDao.getCourseDto(id);
        model.addAttribute("user", users);
        return "user-jsp/edit-add";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userDao.deleteUser(id);
        return "redirect:/user/show";
    }


    @RequestMapping(value = "/add")
    public String addUser(@ModelAttribute("course") UserDto user) {
        userDao.addUser(user);
        return "redirect:/user/show";
    }


    @RequestMapping(value = "/update")
    public String edeted(@ModelAttribute("course") UserDto course) {
        userDao.updateUser(course);
        return "redirect:/user/show";
    }
}
