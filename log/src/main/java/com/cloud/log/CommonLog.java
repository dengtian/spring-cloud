package com.cloud.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class CommonLog<T> implements Serializable {
    private String category;
    private long time;
    private T data;

    public CommonLog(String category, T data) {
        this.category = category;
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    public static <T> CommonLog<T> log(String category, T data) {
        return new CommonLog<>(category, data);
    }
}
