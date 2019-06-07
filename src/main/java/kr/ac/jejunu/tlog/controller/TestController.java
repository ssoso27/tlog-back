package kr.ac.jejunu.tlog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/")
    public String root()
    {
        return "Spring Boot Test";
    }

}
