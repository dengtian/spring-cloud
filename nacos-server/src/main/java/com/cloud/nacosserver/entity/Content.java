package com.cloud.nacosserver.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.nacosserver.enums.FileTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author dt
 * @since 2020-08-03
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName(autoResultMap = true)
public class Content extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String title;
    private String content;
    private FileTypeEnum fileType;
    private String authorId;
}
