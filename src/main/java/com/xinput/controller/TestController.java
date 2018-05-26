package com.xinput.controller;

import com.xinput.entity.Demo;
import com.xinput.entity.Person2;
import com.xinput.entity.User1;
import com.xinput.service.DemoService;
import com.xinput.service.PersonService;
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

    @Autowired
    private PersonService personService;

    @Autowired
    private DemoService demoService;

    /**
     * 访问ds1数据库
     *
     * @return
     */
    @RequestMapping(value = "/ds1", method = RequestMethod.GET)
    public List<User1> user1() {
        return userService.query();
    }

    /**
     * 访问数据库2
     *
     * @return
     */
    @RequestMapping(value = "/ds2", method = RequestMethod.GET)
    public List<Person2> person2() {
        return personService.query();
    }

    @RequestMapping(value = "/ds", method = RequestMethod.GET)
    public List<Demo> demo() {
        return demoService.query();
    }

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public String test() {
        return "adfadfadfa";
    }

}
