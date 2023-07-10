package com.example.kakao;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    @GetMapping("/")
    public String pingpongTest(){
        return "PING PONG!!!!";
    }

    @GetMapping("/loginsuccess")
    public String loginSuccess (){
        return "LoginSuccess!";
    }
}
