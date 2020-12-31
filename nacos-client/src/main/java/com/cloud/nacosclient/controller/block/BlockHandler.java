package com.cloud.nacosclient.controller.block;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlockHandler {
    public static String blockHandler(String name,BlockException e) {
        log.error("限流处理", e);
        return "服务繁忙";
    }

    public static String blockHandlerNoArg(BlockException e) {
        log.error("限流处理", e);
        return "服务繁忙";
    }
}
