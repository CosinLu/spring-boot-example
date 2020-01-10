package com.dur.cosin.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
@RequestMapping("/example")
public class Example {

    @Autowired
    private StringRedisTemplate template;

    @RequestMapping("/read_key")
    public void read_key(String key){
        ValueOperations ops = template.opsForValue();
        Object k = ops.get(key);
        System.out.println(k);
    }

}
