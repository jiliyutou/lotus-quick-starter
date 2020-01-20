package com.lotus.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * 程序启动入口
 *
 * @author haikuo.zhk
 */
@SpringBootApplication
public class Application {

    private final static Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        LOG.info("Start [{}] Application", Application.class.toString());
        SpringApplication.run(Application.class, args);
    }
}