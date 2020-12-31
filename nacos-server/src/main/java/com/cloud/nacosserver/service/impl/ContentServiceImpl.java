package com.cloud.nacosserver.service.impl;

import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.Cached;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.nacosserver.entity.Content;
import com.cloud.nacosserver.entity.ContentViewCount;
import com.cloud.nacosserver.mapper.ContentMapper;
import com.cloud.nacosserver.mapper.ContentViewCountMapper;
import com.cloud.nacosserver.service.IContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dt
 * @since 2020-08-03
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements IContentService {

    @Autowired
    private ContentViewCountMapper viewCountMapper;

    @Cacheable
    public Content getBy(Integer id) {
        return baseMapper.selectOne(new LambdaQueryWrapper<Content>().eq(Content::getId, id));
    }

    @Override
    public boolean removeById(Serializable id) {
        super.removeById(id);
        return false;
    }

    @Override
    public boolean save(Content entity) {
        boolean save = super.save(entity);
        if (save) {
            viewCountMapper.insert(ContentViewCount.builder().contentView(0L).contentId(entity.getId().toString()).build());
        }
        return save;
    }

    @Override
    public PageInfo<Content> getList(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Content> list = baseMapper.getList();
        PageInfo<Content> contentPageInfo = new PageInfo<>(list);
        return contentPageInfo;
    }
}
