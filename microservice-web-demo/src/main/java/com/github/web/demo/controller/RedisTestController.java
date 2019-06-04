package com.github.web.demo.controller;

import com.github.microservice.redis.api.RedisService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-04 上午10:48
 */
@RestController
@RequestMapping("redis")
public class RedisTestController {

	@Reference(version = "${service.redis.version.v1}")
	private RedisService redisService;

	@GetMapping("set")
	public String set(String key, String value) {
		redisService.set(key, value);
		return "ok";
	}
}
