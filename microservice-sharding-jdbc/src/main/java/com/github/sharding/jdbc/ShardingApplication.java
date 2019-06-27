package com.github.sharding.jdbc;

import org.apache.shardingsphere.api.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-27 10:09
 */
@SpringBootApplication
public class ShardingApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void run(String... args) throws Exception {

        System.out.println("--------1-----------");
        jdbcTemplate.update("INSERT INTO test (`id`, `name`, `code`) VALUES (?, '666', '6')", new Random().nextInt(100000));
        System.out.println("--------2-----------");
        HintManager.getInstance().setMasterRouteOnly();
        System.out.println("--------3-----------");
        jdbcTemplate.queryForMap("select * from test where id =?", 3);
        System.out.println("--------4-----------");
        HintManager.clear();
        HintManager.getInstance().setMasterRouteOnly();
        System.out.println("--------5-----------");
        jdbcTemplate.queryForMap("select * from test where id =?", 3);

    }
}
