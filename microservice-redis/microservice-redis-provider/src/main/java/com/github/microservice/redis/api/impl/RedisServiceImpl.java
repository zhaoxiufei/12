package com.github.microservice.redis.api.impl;

import com.github.microservice.redis.api.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.Collections;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-04 下午6:54
 */
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@Slf4j
@Service(version = "${redis.service.version.v1}")
public class RedisServiceImpl implements RedisService {
    private static final RedisScript<String> SCRIPT_UNLOCK = new DefaultRedisScript<>("if redis.call('get',KEYS[1]) == ARGV[1] then return tostring(redis.call('del', KEYS[1])==1) else return 'false' end", String.class);
    private static final String SUCCESS = "OK";
    @Autowired
    private RedisTemplate<String, Object> objectRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> longRedisTemplate;

    @Override
    public void set(String key, Object value) {
        objectRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Long incr(String key) {
        return longRedisTemplate.opsForValue().increment(key);
    }

    @Override
    public Long incr(String key, long value) {
        return longRedisTemplate.opsForValue().increment(key,value);
    }

    @Override
    public void set(String key, Object value, int expire) {
        objectRedisTemplate.opsForValue().set(key, value, expire);
    }

    @Override
    public Boolean lock(String lockKey, String uuid, long seconds) {
        log.info("{},{}", lockKey, uuid);
        return objectRedisTemplate.opsForValue().setIfAbsent(lockKey, uuid, Duration.ofSeconds(seconds));
    }

    @Override
    public Boolean lock(String lockKey, String uuid, Duration duration) {
        return objectRedisTemplate.opsForValue().setIfAbsent(lockKey, uuid, duration);
    }

    @Override
    public Boolean unlock(String lockKey, String uuid) {
        return SUCCESS.equals(objectRedisTemplate.execute(SCRIPT_UNLOCK,
            objectRedisTemplate.getStringSerializer(),
            objectRedisTemplate.getStringSerializer(),
            Collections.singletonList(lockKey),
            uuid));
    }
}
