package com.cloud.nacosserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.nacosserver.entity.Content;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author dt
 * @since 2020-08-03
 */
public interface ContentMapper extends BaseMapper<Content> {
    @Select("select * from content")
    @ResultType(Content.class)
    List<Content> getList();
}
