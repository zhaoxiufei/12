package com.github.microservice.shardingjdbc.masterslave.controller;

import com.github.microservice.shardingjdbc.masterslave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-28 13:56
 */
@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@RestController
@RequestMapping
public class TestController {
    @Autowired
    private UserService userService;

    @GetMapping("t1")
    public String t1() {
        userService.save();
        userService.find();
        userService.find();
        userService.find();
        userService.find();
        userService.findMaster();
        return "ok";
    }
}
