package com.da2win.springbootlesson7.demo;

import com.da2win.springbootlesson7.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class MybatisXmlConfigurationDemo {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));

        ResourceLoader resourceLoader = new DefaultResourceLoader();

        Resource resource = resourceLoader.getResource("classpath:/mybatis/mybatis-config.xml");

        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

        Reader reader = encodedResource.getReader();

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sessionFactory = builder.build(reader, "dev", new Properties());

        SqlSession sqlSession = sessionFactory.openSession();

        User user= sqlSession.selectOne("com.da2win.springbootlesson7.mapper.UserMapper.selectOne", 3);

        System.out.println(user);

        sqlSession.close();
    }
}
