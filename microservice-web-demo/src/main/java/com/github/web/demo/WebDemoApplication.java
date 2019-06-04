package com.github.web.demo;

import org.apache.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-03 下午8:04
 */
@SpringBootApplication
public class WebDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebDemoApplication.class, args);
		Main.main(args);
	}
}
