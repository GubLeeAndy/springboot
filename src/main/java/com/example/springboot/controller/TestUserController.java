package com.example.springboot.controller;

import com.example.springboot.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: TODO()
 * @author: zn
 * @date: Created in 2019/10/29 14:36
 * @version:
 */
@RestController
@RequestMapping(value = "/test",produces = "application/json; charset=utf-8")
@CrossOrigin(allowCredentials = "true")
public class TestUserController {
    @Autowired
    private TestUserService testUserService;

    @RequestMapping(value = "/world",method = RequestMethod.POST)
    public String world(){
        return testUserService.hello();
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(){
        return testUserService.delete();
    }
}
