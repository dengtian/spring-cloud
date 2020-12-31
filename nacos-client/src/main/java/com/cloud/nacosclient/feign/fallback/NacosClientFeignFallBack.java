package com.cloud.nacosclient.feign.fallback;

import com.cloud.nacosclient.feign.NacosClientFeign;
import org.springframework.stereotype.Component;

@Component
public class NacosClientFeignFallBack implements NacosClientFeign {
    @Override
    public String hello(String name) {
        return "服务调用失败";
    }
}
