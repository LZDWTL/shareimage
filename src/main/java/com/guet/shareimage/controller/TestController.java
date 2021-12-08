package com.guet.shareimage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LZDWTL
 * @date 2021-11-29 17:33
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello(String str) {
        return "Hello Spring Boot!"+str;
    }

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);


    @GetMapping("/log")
    public String log(String str) {
        logger.info("这是一条 info 级别的日志"+str);
        logger.error("这是一条 error 级别的日志");
        logger.debug("这是一条 debug 级别的日志");
        logger.warn("这是一条 warn 级别的日志");
        return "日志打印";
    }
}
