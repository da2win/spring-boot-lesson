package com.da2win.springbootlesson7.Controller;

import com.da2win.springbootlesson7.entity2.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @RequestMapping("/user/{id}")
    public User user(@PathVariable int id) {
        User user = sqlSessionTemplate.selectOne("com.da2win.springbootlesson7.mapper2.UserMapper.selectByPrimaryKey", 3);
        return user;
    }

}
