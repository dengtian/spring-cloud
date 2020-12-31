package com.cloud.nacosclient.feign.fallback;

import com.cloud.nacosclient.feign.NacosClientFeign;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NacosClientFeignFallBackFactory implements FallbackFactory<NacosClientFeign> {

    @Override
    public NacosClientFeign create(Throwable throwable) {
        NacosClientFeignFallBack fallback = new NacosClientFeignFallBack();
        log.error("fallback reason :" + throwable.getMessage());
        return fallback;
    }
}
