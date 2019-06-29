package com.github.microservice.transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-28 13:37
 */
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class TransactionalApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransactionalApplication.class, args);
    }
}
