package com.jomkie.sm;

import com.alibaba.druid.pool.DruidDataSource;
import com.jomkie.sm.entity.User;
import com.jomkie.sm.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class JomkieSmApplication {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream(JomkieSmApplication.class.getResource("/").getPath() + "/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll(10, 20, 1);
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

}
