package com.github.microservice.transactional.controller;

import com.github.microservice.transactional.service.RoleService;
import com.github.microservice.transactional.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-28 13:56
 */
@RestController
@RequestMapping
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("t1")
    public String t1() {
        userService.save();
        return "ok";
    }

    @GetMapping("t2")
    public String t2() {
        userService.save3();
        return "ok";
    }

    @GetMapping("t3")
    public String t3() {
        userService.save4();
        return "ok";
    }

    @GetMapping("t4")
    public String t4() {
        userService.save5();
        return "ok";
    }
}
