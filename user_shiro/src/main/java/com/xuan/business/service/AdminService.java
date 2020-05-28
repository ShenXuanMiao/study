package com.xuan.business.service;

public interface AdminService {
    /**
     * 检查name和password是否合法,且判断密码是否正确
     * @param name 用户名称
     * @param password  用户密码
     * @return java.lang.Boolean
     **/
    Boolean login(String name, String password);
}
