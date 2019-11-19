/*
 * LogInterceptor.java
 * Copyright 2018 Qunhe Tech, all rights reserved.
 * Qunhe PROPRIETARY/CONFIDENTIAL, any form of usage is subject to approval.
 */

package com.lotus.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 请求URI日志拦截器
 *
 * @author haikuo.zhk
 */
@Component
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    /** 拦截所有URI */
    private static final String URI_REGEX = "/.*";

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response,
                             final Object o) throws Exception {
        if (request.getRequestURI().matches(URI_REGEX)) {
            final String requestId = UUID.randomUUID().toString();
            final Long current = System.currentTimeMillis();
            request.setAttribute("_uniqueId", requestId);
            request.setAttribute("qh.start", current);

            final String ip = request.getHeader("x-forwarded-for") == null ?
                    request.getRemoteAddr() : request.getHeader("x-forwarded-for");

            log.info("requestStart - _uniqueId:{}, ip:{}, uri:{}, method:{}, queryString: {}",
                    requestId, ip,
                    request.getRequestURI(),
                    request.getMethod(),
                    request.getQueryString());
        }
        return true;
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response,
                           final Object o, final ModelAndView modelAndView) throws Exception {
        if (request.getRequestURI().matches(URI_REGEX)) {
            Long start = request.getAttribute("qh.start") == null ? 0L : (Long) request.getAttribute("qh.start");

            log.info("requestEnd - _uniqueId:{}, took:{}, uri:{}, method:{}, queryString:{}",
                    request.getAttribute("_uniqueId"),
                    (start == 0) ? -1 : System.currentTimeMillis() - start,
                    request.getRequestURI(),
                    request.getMethod(),
                    request.getQueryString());
        }
    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
                                final Object o, final Exception e) throws Exception {
        // TODO: completion
    }
}
