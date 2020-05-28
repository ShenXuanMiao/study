package com.xuan.business.service.impl;

import com.xuan.business.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * @author shenxuan
 * @date 2019/3/22
 **/
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Override
    public Boolean login(String name, String password) {
        return true;
    }
}
