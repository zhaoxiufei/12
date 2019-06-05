package com.github.web.demo.controller;

import com.github.microservice.redis.api.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-04 上午10:48
 */
@Slf4j
@RestController
@RequestMapping("redis")
public class RedisTestController {

    @Reference(version = "${redis.service.version.v1}")
    private RedisService redisService;

    @GetMapping("test")
    public String set(String key, String value) {
        redisService.set(key, value);
        System.out.println(redisService.incr("5550"));
        System.out.println(redisService.incr("5550", 5));
        return "ok";
    }

    private long num = 10;

    @GetMapping("lock")
    public String lock(String key, String value) {
        num = 100;
        redisService.set(key, value);
        List<String> shopUsers = new ArrayList<>(10);
        //构造很多用户
        List<String> users = new ArrayList<>();
        IntStream.range(0, 100000).parallel().forEach(b -> users.add("神牛-" + b));
        //模拟开抢
        users.parallelStream().forEach(b -> {
            String shopUser = qiang(b);
            if (!StringUtils.isEmpty(shopUser)) {
                shopUsers.add(shopUser);
            }
        });
        return "ok";
    }

    /**
     * 模拟抢单动作
     */
    private String qiang(String b) {
        //用户开抢时间
        long startTime = System.currentTimeMillis();

        //未抢到的情况下，30秒内继续获取锁
        int timeout = 30 * 1000;
        while ((startTime + timeout) >= System.currentTimeMillis()) {
            //商品是否剩余
            if (num <= 0) {
                break;
            }
            String shangpingKey = "computer_key";
            if (redisService.lock(shangpingKey, b, 3)) {
                //用户b拿到锁
                log.info("用户{}拿到锁...", b);
                try {
                    //商品是否剩余
                    if (num <= 0) {
                        break;
                    }
                    //模拟生成订单耗时操作，方便查看：神牛-50 多次获取锁记录
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //抢购成功，商品递减，记录用户
                    num -= 1;
                    //抢单成功跳出
                    log.info("用户{}抢单成功跳出...所剩库存：{}", b, num);
                    return b + "抢单成功，所剩库存：" + num;
                } finally {
                    log.info("用户{}释放锁...", b);
                    redisService.unlock(shangpingKey, b);
                }
            } else {
                //用户b没拿到锁，在超时范围内继续请求锁，不需要处理
                if (b.equals("神牛-50") || b.equals("神牛-69")) {
                    log.info("用户{}等待获取锁...", b);
                }
            }
        }
        return "";
    }
}
