package com.github.microservice.crawler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import us.codecraft.webmagic.Spider;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-09-16 10:22
 */
@SpringBootApplication
public class CrawlerApplication implements CommandLineRunner {

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(CrawlerApplication.class)
            .web(WebApplicationType.NONE)
            .run(args);
//        SpringApplication.run(Application.class);
    }

    @Override
    public void run(String... args) throws Exception {
        Spider.create(new GithubRepoPageProcessor()).addUrl("https://github.com/code4craft").thread(5).run();

    }
}
