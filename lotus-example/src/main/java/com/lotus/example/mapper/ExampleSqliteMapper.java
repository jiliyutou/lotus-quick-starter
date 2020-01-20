package com.lotus.example.mapper;

import com.lotus.example.ExampleDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Mybatis - Sqlite  Mapper实现
 *
 * @author haikuo.zhk
 */
@Mapper
public interface ExampleSqliteMapper extends ExampleMapper {

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

    @Insert("INSERT INTO tb_example(key, value, created, last_modified) VALUES(#{key}, #{value}, strftime('%Y-%m-%d %H:%M:%f','now', 'localtime'), strftime('%Y-%m-%d %H:%M:%f','now', 'localtime'))")
    int insert(ExampleDO example);

    @Update("UPDATE tb_example set value=#{value}, last_modified=strftime('%Y-%m-%d %H:%M:%f','now', 'localtime') WHERE key=#{key}")
    int update(ExampleDO example);
}