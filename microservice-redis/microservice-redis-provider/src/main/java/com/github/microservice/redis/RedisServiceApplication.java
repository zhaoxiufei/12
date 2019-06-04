package com.github.microservice.redis;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-03 下午7:39
 */
@SpringBootApplication
public class RedisServiceApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(RedisServiceApplication.class)
			.web(WebApplicationType.NONE)
			.run(args);
	}
}
