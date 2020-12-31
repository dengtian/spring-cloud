package com.cloud.nacosserver.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author dt
 * @since 2020-10-14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AppConfig extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 属性名称
     */
    private String property;

    /**
     * 属性值
     */
    private String value;

    private String remark;

}
