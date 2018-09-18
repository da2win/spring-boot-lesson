package com.da2win.springbootlesson7.annotation;

import com.da2win.springbootlesson7.entity2.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Results(value = {
            @Result(property = "id", column = "id", id=true),
            @Result(property = "age", column = "age"),
            @Result(property = "name", column = "name")
    })
    @Select("SELECT id, name, age FROM user WHERE id = #{id}")
    User selectUser(int id);
}
