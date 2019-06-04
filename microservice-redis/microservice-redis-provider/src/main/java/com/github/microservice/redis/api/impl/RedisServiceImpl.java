package com.github.microservice.redis.api.impl;

import com.github.microservice.redis.api.RedisService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-04 下午6:54
 */
@Service(version = "${redis.service.version.v1}")
public class RedisServiceImpl implements RedisService {
	@Autowired
	private RedisTemplate redisTemplate;
	@Override
	public void set(String key, Object value) {
		System.out.println(value);
		redisTemplate.opsForValue().set(key,value);
	}
}
