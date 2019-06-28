package com.github.microservice.log.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-27 17:33
 */
@Slf4j
@SpringBootApplication
public class LogBackApplication implements CommandLineRunner {
    public static void main(String[] args) {
        new SpringApplicationBuilder(LogBackApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("----你好------");
    }
}
