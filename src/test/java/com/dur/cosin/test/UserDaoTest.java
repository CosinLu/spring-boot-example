package com.dur.cosin.test;

import com.dur.cosin.dao.UserDao;
import com.dur.cosin.example.UserDaoExam;
import com.dur.cosin.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class UserDaoTest {
    public UserDao userDao;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        this.userDao = new UserDaoExam(sqlSession);

    }

    @Test
    public void queryUserById() {
        System.out.println(this.userDao.queryUserById(1));
    }

    @Test
    public void queryUserAll() {
        List<User> userList = this.userDao.queryUserAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws Exception {
        LocalDate date1 = LocalDate.of(1994,10,10);
        User user = new User();
        user.setAge(16);
        user.setBirthday(date1);
        user.setName("大鹏");
        user.setPassword("123456");
        user.setSex(1);
        user.setUserName("evan");
        this.userDao.insertUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void updateUser() throws Exception {
        LocalDate date1 = LocalDate.of(1994,8,15);
        User user = new User();
        user.setBirthday(date1);
        user.setName("静鹏");
        user.setPassword("6543210");
        user.setSex(1);
        user.setUserName("evanjin");
        user.setId(1);
        this.userDao.updateUser(user);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUser() throws Exception {
        this.userDao.deleteUser("2");
        this.sqlSession.commit();
    }

}