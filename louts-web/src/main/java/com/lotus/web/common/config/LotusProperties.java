package com.lotus.web.common.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/***
 * 自定义配置文件
 *
 * @haikuo.zhk
 */
@Data
@Configuration
@PropertySource(value = {"classpath:lotus.properties"})
public class LotusProperties {

    @Value("${project.version}")
    private String projectVersion;

    @Value("${project.stage}")
    private String projectStage;

    // Add additional config here
}
