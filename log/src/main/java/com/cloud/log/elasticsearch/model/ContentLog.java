package com.cloud.log.elasticsearch.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ContentLog {
    private Integer id;

    private Integer contentId;

    private String userId;

    private Long timestamp;
}
