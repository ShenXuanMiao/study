package com.xuan.security.dao;

import com.xuan.security.bean.Permission;

import java.util.List;

public interface PermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    List<Permission>  selectByRoleId(Integer roleId);
}