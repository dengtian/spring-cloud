package com.cloud.nacosserver.controller;


import com.cloud.nacosserver.service.IAppConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dt
 * @since 2020-10-14
 */
@RestController
@RequestMapping("//app-config")
public class AppConfigController {

    @Autowired
    IAppConfigService appConfigService;

    @Value(("${server.port}"))
    private String port;

    @GetMapping("config")
    public Object config(){

        return port;
    }

}
