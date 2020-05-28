package com.xuan.security.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DaoUtil {
    private static SqlSessionFactory sqlSessionFactory=null;
    private  DaoUtil(){}
    public static synchronized SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory==null){
            String resource = "mybatis-config.xml";
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  new SqlSessionFactoryBuilder().build(inputStream);
        }else{
            return  sqlSessionFactory;
        }
    }
}
