package com.xuan.security.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class SubjectManager {
    /**
     * 身份凭证验证方法,并返回对应的subject
     * @param configFile  String  shiro配置文件地址
     * @param username  String  需要验证的身份
     * @param password  String  需要验证的凭证
     */
    public static void login(String configFile,String username ,String password){
        Factory<SecurityManager> factory=new IniSecurityManagerFactory(configFile);
        SecurityUtils.setSecurityManager(factory.getInstance());
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        subject.login(usernamePasswordToken);

    }
    private SubjectManager(){}
    public static Session getSession(){
        Subject subject = SecurityUtils.getSubject();
        return subject.getSession();
    }
}
