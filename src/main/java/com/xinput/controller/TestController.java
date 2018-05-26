package com.xinput.controller;

import com.xinput.entity.User1;
import com.xinput.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xinput
 * @date 2018-05-24 23:23
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user1", method = RequestMethod.GET)
    public List<User1> user1() {
        return userService.query();
    }

}
