package com.dur.cosin.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("/redis")
public class Redis {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/get")
    public String get(String key){
        ValueOperations ops = redisTemplate.opsForValue();
        Object data = ops.get(key);
        return  data.toString();
    }

}
