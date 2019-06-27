package com.github.sharding.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-27 09:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestShardingjdcb {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void hhahaha() {
        jdbcTemplate.queryForMap("select * from access_log where id =?", "35c413cb83e94b24918eb2b7409384bb");
    }

}
