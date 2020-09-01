package com.lotus.web.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/***
 * redis样例操作控制器
 *
 * @author haikuo.zhk
 */
@RestController
@RequestMapping("/ops/redis")
public class RedisSampleController {

    private final static String REDIS_KEY_PREFIX = "lotus-quick-starter";

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @RequestMapping("/set")
    public String setRedisValue() {
        redisTemplate.opsForValue().set(REDIS_KEY_PREFIX + "opsForValue", "value", 60, TimeUnit.SECONDS);
        redisTemplate.opsForHash().put(REDIS_KEY_PREFIX + "opsForHash", "mapKey", "mapValue");
        return "success & ok";
    }

    @RequestMapping("/get")
    public String getRedisValue() {
        System.out.println(redisTemplate.opsForValue().get(REDIS_KEY_PREFIX + "opsForValue"));
        System.out.println(redisTemplate.opsForHash().get(REDIS_KEY_PREFIX + "opsForHash", "mapKey"));
        return "success & ok";
    }
}
