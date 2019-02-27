package com.Sugarda.userManageService.controller;

import com.Sugarda.userManageService.service.SugardaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userChange")
public class UserController {
    @Autowired
    private SugardaUserService sugardaUserService;
}
