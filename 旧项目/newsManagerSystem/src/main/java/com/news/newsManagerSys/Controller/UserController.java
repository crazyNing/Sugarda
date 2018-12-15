package com.news.newsManagerSys.Controller;

import com.news.newsManagerSys.Dao.Entity.User;
import com.news.newsManagerSys.Dao.Entity.Vo.UserVo;
import com.news.newsManagerSys.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/showUsers")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/login")
    public UserVo findUserByAuthorId(@RequestParam String userName, @RequestParam String userPwd) {
        User user = userService.findUserByUserNameAndUserPwd(userName, userPwd);
        UserVo userVo;
        if (user == null) {
            User userNull = new User();
            userVo = new UserVo(userNull);
            userVo.setStateNo(1);
            userVo.setNotice("此用户不存在");
        } else {
            userVo = new UserVo(user);
        }
        if (user == null) {
            userVo.setStateNo(1);
            userVo.setNotice("此用户不存在");
        } else if (!userPwd.equals(user.getUserPwd())) {
            userVo.setStateNo(1);
            userVo.setNotice("对不起，您的密码输入错误");
            userVo.setUserName(null);
            userVo.setUserRole(null);
            userVo.setUserAuthor(null);
        } else {
            userVo.setStateNo(0);
            userVo.setNotice("登陆成功！");
        }
        return userVo;
    }
}
