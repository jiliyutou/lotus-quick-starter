package com.lotus.example.mapper;

import com.lotus.example.ExampleDO;

import java.util.List;

/***
 * 抽象接口
 *
 * @author haikuo.zhk
 */
public interface ExampleMapper {

    List<ExampleDO> queryAll();

    ExampleDO queryByKey(String key);

    int insert(ExampleDO example);

    int update(ExampleDO example);
}
