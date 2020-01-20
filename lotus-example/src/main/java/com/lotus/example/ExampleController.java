package com.lotus.example;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {

    @Value("${spring.datasource.driver-class-name")
    private String driverClassName;

    private ExampleMapper mExampleMapper;

    @GetMapping("/queryAll")
    public List<ExampleDO> queryAll() {
        return mExampleMapper.queryAll();
    }

    @GetMapping("/queryByKey")
    public ExampleDO queryById(@Param("key") String key) {
        return mExampleMapper.queryByKey(key);
    }

    @GetMapping("/insert")
    public ExampleDO insert(@Param("key") String key, @Param("value") String value) {
        mExampleMapper.insert(new ExampleDO().setKey(key).setValue(value));
        return mExampleMapper.queryByKey(key);
    }

    @GetMapping("/update")
    public ExampleDO update(@Param("key") String key, @Param("value") String value){
        mExampleMapper.update(new ExampleDO().setKey(key).setValue(value));
        return mExampleMapper.queryByKey(key);
    }

    public ExampleMapper getmExampleMapper() {
        if(driverClassName.equalsIgnoreCase("org.h2.Driver")) {
            driverClassName.
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
