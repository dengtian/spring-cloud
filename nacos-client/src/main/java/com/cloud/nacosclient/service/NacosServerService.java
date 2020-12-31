package com.cloud.nacosclient.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.nacosclient.controller.block.BlockHandler;
import com.cloud.nacosclient.feign.NacosClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NacosServerService {
    @Autowired
    NacosClientFeign feign;

    @SentinelResource(value = "name", blockHandlerClass = BlockHandler.class, blockHandler = "blockHandler")
    public String hello(String name) {
        return feign.hello(name);
    }
}
