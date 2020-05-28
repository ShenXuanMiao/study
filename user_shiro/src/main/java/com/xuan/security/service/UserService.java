package com.xuan.security.service;

import com.xuan.security.bean.User;

public interface UserService {
    User getUser(String username);
    boolean updataUser(User user);
}
