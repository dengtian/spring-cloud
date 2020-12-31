package com.cloud.nacosserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.nacosserver.entity.Content;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author dt
 * @since 2020-08-03
 */
public interface IContentService extends IService<Content> {
    Content getBy(Integer id);

    PageInfo<Content> getList(int pageNo,int pageSize);
}
