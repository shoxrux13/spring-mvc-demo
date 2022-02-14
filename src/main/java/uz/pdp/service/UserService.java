package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dao.CurseDao;
import uz.pdp.dao.UserDao;
import uz.pdp.dto.CourseDto;
import uz.pdp.dto.UserDto;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    CurseDao courseDao;

    public List<UserDto> userDtoList(){
        List<UserDto> userDto = userDao.getAllCourseDto();
        return userDto;
    }

    public List<CourseDto> courseDtoByUserId(Integer id){
        return  courseDao.getCourseByUserId(id);
    }

    public List<UserDto> getCourseByUserIdDao(){
        List<UserDto> userDto = userDao.getAllCourseDto();
        return userDto;
    }


    public UserDto userDtoById(int id){
        return userDao.getUsesDtoById(id);
    }

    public UserDto getUserByUsername(String username, String password){
        return userDao.getUserDtoByUsername(username, password);
    }

}
