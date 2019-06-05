package com.github.microservice.redis.api;

import java.time.Duration;

/**
 * @author <a href="mailto:zhaoxiufei@gmail.com">赵秀非</a>
 * @since 2019-06-03 下午2:05
 */
public interface RedisService {
    void set(String key, Object value);
    Long incr(String key);
    Long incr(String key, long value);

    void set(String key, Object value, int expire);

    Boolean lock(String lockKey, String uuid, long seconds);

    Boolean lock(String lockKey, String uuid, Duration duration);

    Boolean unlock(String lockKey, String uuid);
}
