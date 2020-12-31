package com.cloud.nacosserver;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.cloud")
@MapperScan(basePackages = "com.cloud.nacosserver.mapper")
@EnableCreateCacheAnnotation
public class NacosServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosServerApplication.class, args);
    }

}
