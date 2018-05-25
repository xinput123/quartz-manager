package com.xinput.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xinput
 * @date 2018-05-24 23:23
 */
@RestController
public class UserController {

    @RequestMapping(value = "/user1", method = RequestMethod.GET)
    public void user1() {

    }

}
