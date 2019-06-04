package com.github.microservice.redis.provider;

import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-03 下午7:39
 */
@SpringBootApplication
public class RedisServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(RedisServiceApplication.class, args);
		Main.main(args);
	}
}
