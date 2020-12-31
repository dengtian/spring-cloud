package com.cloud.nacosclient.feign;

import com.cloud.nacosclient.feign.fallback.NacosClientFeignFallBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "nacos-server", fallbackFactory = NacosClientFeignFallBackFactory.class)
public interface NacosClientFeign {
    @GetMapping("/hello")
    String hello(@RequestParam String name);
}
