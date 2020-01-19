package com.lotus.example;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired
    private ExampleMapper mExampleMapper;

    @GetMapping("/queryAll")
    public Object queryAll() {
        return mExampleMapper.queryAll();
    }

    @GetMapping("/queryByKey")
    public Object queryById(@Param("key") String key) {
        return mExampleMapper.queryByKey(key);
    }

    @GetMapping("/insert")
    public Object insert(@Param("key") String key, @Param("value") String value) {
        mExampleMapper.insert(new ExampleDO().setKey(key).setValue(value));
        return mExampleMapper.queryByKey(key);
    }

    @GetMapping("/update")
    public Object update(@Param("key") String key, @Param("value") String value){
        mExampleMapper.update(new ExampleDO().setKey(key).setValue(value));
        return mExampleMapper.queryByKey(key);
    }
}
