package com.cloud.nacosserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class NacosServerController {

    @GetMapping("/hello")
    public ResponseEntity hello(@RequestParam String name) {
        log.info("hello :" + name);
        return new ResponseEntity("hello " + name, HttpStatus.OK);
    }
}
