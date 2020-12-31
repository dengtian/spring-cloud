package com.cloud.nacosserver.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.nacosserver.entity.AppConfig;
import com.cloud.nacosserver.mapper.AppConfigMapper;
import com.cloud.nacosserver.service.IAppConfigService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dt
 * @since 2020-10-14
 */
@Service
public class AppConfigServiceImpl extends ServiceImpl<AppConfigMapper, AppConfig> implements IAppConfigService {

    @Value("&{spring.application.cloud.nacos.discovery.server-addr}")
    private String nacosAddr;


    public List<AppConfig> getAppConfigFromNacos() {
        if (StrUtil.isNotEmpty(nacosAddr)) {
            String config = getConfigFromNacos(nacosAddr, "yida-data.yaml", "DEFAULT_GROUP");
            if (StrUtil.isNotEmpty(config)) {
                Yaml yaml = new Yaml();
                Map load = yaml.loadAs(config, Map.class);
                if (MapUtil.isNotEmpty(load)) {
                    List<AppConfig> appConfigs = baseMapper.selectList(new LambdaQueryWrapper<>());
                    if (CollectionUtil.isNotEmpty(appConfigs)){
                        appConfigs.forEach(e->{
                            Object o = load.get(e.getProperty());
                            e.setValue(o.toString());
                        });
                        return appConfigs;
                    }
                }

            }
        }
        return Collections.emptyList();
    }


    public String getConfigFromNacos(String serverAddr, String dataId, String group) {
        try {
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            ConfigService configService = NacosFactory.createConfigService(properties);
            return configService.getConfig(dataId, group, 3000);
        } catch (NacosException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean publishConfigToNacos(String serverAddr, String dataId, String group, String config) {
        try {
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            ConfigService configService = NacosFactory.createConfigService(properties);
            return configService.publishConfig(dataId, group, config);
        } catch (NacosException e) {
            e.printStackTrace();
            return false;
        }
    }
}
