package com.github.web.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-04 上午10:48
 */
@Slf4j
@RestController
@RequestMapping("redis")
public class RedisTestController {

    @GetMapping("test")
    public String set(String key, String value) {
        return "ok";
    }
}
