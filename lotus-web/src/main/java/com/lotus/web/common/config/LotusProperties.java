package com.lotus.web.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;

/***
 * 自定义配置文件
 *
 * @haikuo.zhk
 */
@Data
@Configuration
@PropertySource(value = {"classpath:stage.properties", "classpath:lotus.properties"})
public class
LotusProperties {

    @Value("${sys.current.orm}")
    private String currentOrm;

    // Add additional config here

    // stage config here
    @Value("${project.version}")
    private String projectVersion;

    @Value("${project.stage}")
    private String projectStage;
}
