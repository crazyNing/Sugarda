package com.staff.staffManager.controller;

import com.staff.staffManager.dao.entity.User;
import com.staff.staffManager.dao.entity.vo.ResponseDto;
import com.staff.staffManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    ResponseDto login(@RequestBody User user) {
        return userService.login(user.getUserName(), user.getPassword());
    }
}
