package com.dur.cosin.example;

import com.dur.cosin.dao.UserDao;
import com.dur.cosin.model.User;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class UserDaoExam implements UserDao {

    public SqlSession sqlSession;

    public UserDaoExam(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }

    @Override
    public User queryUserById(int id){
        return this.sqlSession.selectOne("UserDao.queryUserById",id);
    }

    @Override
    public List<User> queryUserAll(){
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    @Override
    public void insertUser(User user){
        this.sqlSession.insert("UserDao.insertUser",user);
    }

    @Override
    public void updateUser(User user){
        this.sqlSession.update("UserDao.updateUser",user);
    }

    @Override
    public void deleteUser(String id){
        this.sqlSession.delete("UserDao.deleteUser",id);
    }

}
