package com.github.microservice.shardingjdbc.masterslave;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-27 10:09
 */
@SpringBootApplication
public class ShardingJdbcMasterSlaveApplication implements CommandLineRunner {
    public static void main(String[] args) {

        SpringApplication.run(ShardingJdbcMasterSlaveApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
