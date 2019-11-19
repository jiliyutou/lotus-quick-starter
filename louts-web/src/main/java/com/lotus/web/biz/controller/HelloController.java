package com.lotus.web.biz.controller;

import com.lotus.web.common.config.LotusProperties;
import com.lotus.web.exception.BizzException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

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
}
