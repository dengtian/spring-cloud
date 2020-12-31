package com.cloud.nacosserver;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;
import java.util.Properties;

@SpringBootTest
class NacosServerApplicationTests {

    protected static final String DOT = ".";


    @Test
    public void test() {
    }

    public static void main(String[] args) {
        try {

            System.out.printf(Integer.valueOf("213321").toString());
            // 初始化配置服务，控制台通过示例代码自动获取下面参数
//            String serverAddr = "127.0.0.1:8848";
//            String dataId = "yida-client.yaml";
//            String group = "DEFAULT_GROUP";
//            Properties properties = new Properties();
//            properties.put("serverAddr", serverAddr);
//            ConfigService configService = NacosFactory.createConfigService(properties);
////            boolean isPublishOk = configService.publishConfig(dataId, group, "nacos: hello nacos");
//            String config = configService.getConfig(dataId, group, 5000);
//            System.out.println(config);
//
//
//            Yaml yaml = new Yaml();
//            Map load = yaml.load(config);
//            load.values();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
