package com.github.microservice.redis.api;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-03 下午2:05
 */
public interface RedisService {
	void set(String key, Object value);
}
