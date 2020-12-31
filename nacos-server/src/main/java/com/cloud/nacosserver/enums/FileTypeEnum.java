package com.cloud.nacosserver.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum FileTypeEnum implements IEnum<String> {
    RIGHT_ONE_IMG("RIGHT_ONE_IMG", "右单图"),
    BIG_OMG("BIG_OMG", "大图"),
    VIDEO("VIDEO", "视频");

    FileTypeEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private String value;
    private String desc;

    @Override
    public String getValue() {
        return value;
    }
}
