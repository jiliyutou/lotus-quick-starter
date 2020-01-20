package com.lotus.web.biz.controller;

import com.lotus.web.common.config.LotusProperties;
import com.lotus.web.exception.BizzException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * 健康检查控制器
 *
 * @author haikuo.zhk
 */
@RestController
public class HealthController {

    @Autowired
    private LotusProperties lotusProperties;

    @RequestMapping("/status")
    public String status() {
        return "success & ok";
    }

    @RequestMapping("/ex")
    public String ex() throws BizzException {
        throw new BizzException("ex");
    }

    @RequestMapping("/stage")
    public String stage() {
        return lotusProperties.getProjectVersion() + "@" + lotusProperties.getProjectStage();
    }
}
