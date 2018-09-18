package com.da2win.springbootlesson7.demo;

import com.da2win.springbootlesson7.entity2.User;
import com.da2win.springbootlesson7.entity2.UserExample;
import com.da2win.springbootlesson7.mapper2.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

public class MybatisGeneratorDemo {

    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream("mybatis/mybatis-config.xml");

        InputStreamReader streamReader = new InputStreamReader(inputStream, "UTF-8");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sessionFactory = builder.build(streamReader, "dev", new Properties());

        SqlSession sqlSession = sessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserExample userExample = new UserExample();

        UserExample.Criteria criteria = userExample.createCriteria();

        criteria.andIdEqualTo(3);

        List<User> users = mapper.selectByExample(userExample);

        User user = users.get(0);

        System.out.println(user);

        sqlSession.close();
    }
}
