package com.dur.cosin.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class example {


    @RequestMapping("example")
    String example(){
        System.out.println("cosin");
        return "this is example";
    }
}
