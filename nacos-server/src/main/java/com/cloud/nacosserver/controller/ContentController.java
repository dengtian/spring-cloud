package com.cloud.nacosserver.controller;


import cn.hutool.core.util.RandomUtil;
import com.cloud.api.CommonResult;
import com.cloud.api.ResultCode;
import com.cloud.log.LogSender;
import com.cloud.log.elasticsearch.model.ContentLog;
import com.cloud.nacosserver.entity.Content;
import com.cloud.nacosserver.service.IContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author dt
 * @since 2020-08-03
 */
@Slf4j
@RestController
@RequestMapping("content")
public class ContentController {
    @Autowired
    IContentService contentService;

    @Autowired
    LogSender logSender;

    @RequestMapping(value = "getBy", method = RequestMethod.GET)
    public CommonResult getBy(@RequestParam(value = "id") Integer id, @RequestParam(required = false) String userId) {
        Content one;
        try {
            one = contentService.getBy(id);
            RandomUtil.getRandom().nextInt(2);
            logSender.log("content_log", new ContentLog().setContentId(RandomUtil.getRandom().nextInt(1, 3)).setTimestamp(System.currentTimeMillis()).setUserId(userId));
            return CommonResult.success(one);
        } catch (Exception e) {
            log.error("getBy error", e);
            return CommonResult.failed(ResultCode.FAILED);
        }
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public CommonResult delete(@RequestParam Integer id) {
        contentService.removeById(id);
        return CommonResult.success("成功");
    }


    @RequestMapping(value = "saveOrUpdate", method = RequestMethod.POST)
    public CommonResult saveOrUpdate(Content content) {
        boolean save = contentService.saveOrUpdate(content);
        return CommonResult.success("成功");
    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public CommonResult getList(@RequestParam int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return CommonResult.success(contentService.getList(pageNo, pageSize));
    }
}
