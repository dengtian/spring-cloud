package com.cloud.nacosclient.controller;

import com.cloud.nacosclient.feign.NacosClientFeign;
import com.cloud.nacosclient.service.NacosServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RefreshScope
@RestController
public class NacosClientController {
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    NacosClientFeign feign;

    @Autowired
    NacosServerService nacosServerService;

    @Value("${center_id}")
    String name;

    @GetMapping("client")
    public ResponseEntity client() {
        ServiceInstance instance = loadBalancerClient.choose("nacos-server");
        String s = instance.getUri() + "/hello?name=nacos-client";
        String forObject = new RestTemplate().getForObject(s, String.class);
        return new ResponseEntity(forObject, HttpStatus.OK);
    }

    @GetMapping("clientFeign")
    public ResponseEntity clientFeign() {
        return new ResponseEntity(feign.hello("nacos-client"), HttpStatus.OK);
    }

    @GetMapping("clientFeignSR")
    public ResponseEntity clientFeignSR() {
        return new ResponseEntity(nacosServerService.hello("nacos-client"), HttpStatus.OK);
    }

    @GetMapping("config")
    public ResponseEntity config() {
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

    @GetMapping("/hellosr")
    public String hellosr() {
        return "didispace.com";
    }

}
