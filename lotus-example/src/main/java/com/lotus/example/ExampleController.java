package com.lotus.example;

import com.lotus.example.mapper.ExampleH2Mapper;
import com.lotus.example.mapper.ExampleMapper;
import com.lotus.example.mapper.ExampleSqliteMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Autowired
    private ExampleH2Mapper mExampleH2Mapper;
    @Autowired
    private ExampleSqliteMapper mExampleSqliteMapper;

    /***
     * 根据驱动类型获取具体的Mapper实现
     *
     * @return
     */
    private ExampleMapper getExampleMapper() {
        return driverClassName.equalsIgnoreCase("org.h2.Driver")
                ? mExampleH2Mapper : mExampleSqliteMapper;
    }

    @GetMapping("/queryAll")
    public List<ExampleDO> queryAll() {
        return getExampleMapper().queryAll();
    }

    @GetMapping("/queryByKey")
    public ExampleDO queryByKey(@Param("key") String key) {
        return getExampleMapper().queryByKey(key);
    }

    @GetMapping("/insert")
    public ExampleDO insert(@Param("key") String key, @Param("value") String value) {
        getExampleMapper().insert(new ExampleDO().setKey(key).setValue(value));
        return getExampleMapper().queryByKey(key);
    }

    @GetMapping("/update")
    public ExampleDO update(@Param("key") String key, @Param("value") String value){
        getExampleMapper().update(new ExampleDO().setKey(key).setValue(value));
        return getExampleMapper().queryByKey(key);
    }

}
