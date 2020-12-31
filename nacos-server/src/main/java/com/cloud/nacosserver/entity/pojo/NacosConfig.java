package com.cloud.nacosserver.entity.pojo;

public class NacosConfig {
    String dataId;
    String group;
    String config;

    public NacosConfig() {
    }

    public String getDataId() {
        return dataId;
    }

    public NacosConfig setDataId(String dataId) {
        this.dataId = dataId;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public NacosConfig setGroup(String group) {
        this.group = group;
        return this;
    }

    public String getConfig() {
        return config;
    }

    public NacosConfig setConfig(String config) {
        this.config = config;
        return this;
    }
}
