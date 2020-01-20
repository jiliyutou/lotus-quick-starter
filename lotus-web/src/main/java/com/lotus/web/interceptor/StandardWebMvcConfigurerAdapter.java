/*
 * MyWebMvcConfigurerAdapter.java
 * Copyright 2018 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.lotus.web.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * WebMvc 配置适配器
 *
 * @author haikuo.zhk
 */
@SpringBootConfiguration
public class StandardWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    private LogInterceptor logInterceptor;

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        registry.addInterceptor(logInterceptor)
                .addPathPatterns("/**");

        super.addInterceptors(registry);
    }
}
