package com.xuan.security.service.impl;

import com.xuan.security.bean.User;
import com.xuan.security.dao.DaoUtil;
import com.xuan.security.dao.UserDao;
import com.xuan.security.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author shenxuan
 * @date 2019/5/1
 **/
public class UserServiceImpl implements UserService {

    public static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public User getUser(String username) {
        SqlSession sqlSession = null;
        User user=null;
        try {
            SqlSessionFactory sqlSessionFactory = DaoUtil.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            user = userDao.selectByUsername(username);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (user == null) {
            throw new UnknownAccountException();
        }
        return user;
    }

    @Override
    public boolean updataUser(User user) {
        SqlSession sqlSession = null;
        int i=0;
        try {
            SqlSessionFactory sqlSessionFactory = DaoUtil.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            i = userDao.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        if (i<0){
            LOGGER.error("修改失败");
            return false;
        }else
            return true;
    }
}
