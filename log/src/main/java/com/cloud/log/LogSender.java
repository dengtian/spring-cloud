package com.cloud.log;

import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LogSender {

    @Value("${log.kafka.topic}")
    String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void log(String topic, Object data) {
        ThreadUtil.execute(() -> kafkaTemplate.send(topic, JSON.toJSONString(data)));
    }
}
