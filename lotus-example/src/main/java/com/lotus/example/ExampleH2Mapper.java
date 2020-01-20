package com.lotus.example;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExampleH2Mapper extends ExampleMapper {

    @Select("SELECT * FROM tb_example ORDER BY last_modified DESC")
    @Results({
            @Result(property = "lastModified", column = "last_modified"),
    })
    List<ExampleDO> queryAll();

    @Select("SELECT * FROM tb_example WHERE key=#{key}")
    @Results({
            @Result(property = "lastModified", column = "last_modified"),
    })
    ExampleDO queryByKey(String key);

    @Insert("INSERT INTO tb_example(key, value, created, last_modified) VALUES(#{key}, #{value}, now(), now())")
    int insert(ExampleDO example);

    @Update("UPDATE tb_example set value=#{value}, last_modified=now() WHERE key=#{key}")
    int update(ExampleDO example);
}
