package com.uplus.qualityweb.web;


import com.uplus.qualityweb.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    int a;
    int b;

    int rrr;
    int kkk;


    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name ,
                                     @RequestParam("amount") int amount) {

        return new HelloResponseDto(name, amount);
    }
}
