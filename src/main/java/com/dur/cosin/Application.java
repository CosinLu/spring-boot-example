package com.dur.cosin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class Application {

    @NotNull
    @Valid
    String name;

    @RequestMapping("home")
    String home(String name) {
        return "Hello "+name;
    }

    @RequestMapping("test")
    String test(){
        return "test";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}