package com.xuan.security.realm;

import com.xuan.security.bean.Permission;
import com.xuan.security.bean.Role;
import com.xuan.security.bean.User;
import com.xuan.security.dao.DaoUtil;
import com.xuan.security.dao.PermissionDao;
import com.xuan.security.dao.RoleDao;
import com.xuan.security.dao.UserDao;
import com.xuan.security.service.UserService;
import com.xuan.security.service.impl.UserServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyRealm extends AuthorizingRealm {


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();  //得到用户名
        UserService userService = new UserServiceImpl();
        User user = userService.getUser(username);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, user.getPasswod(), getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(user.getSalt()));
        return info;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String name = (String) principals.getPrimaryPrincipal();
        SqlSession sqlSession = null;
        Set<String> permissionSet = new HashSet<>();
        Set<String> roleSet = new HashSet<>();
        List<Role> roleList;

        try {
            SqlSessionFactory sqlSessionFactory = DaoUtil.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            RoleDao roleDao = sqlSession.getMapper(RoleDao.class);
            PermissionDao permissionDao = sqlSession.getMapper(PermissionDao.class);
            User user = userDao.selectByUsername(name);
            roleList = roleDao.selectByUserId(user.getId());
            roleList.forEach(role -> {
                roleSet.add(role.getRoleName());
                List<Permission> permissions = permissionDao.selectByRoleId(role.getId());
                permissions.forEach(permission -> permissionSet.add(permission.getContent()));
            });

        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        authorizationInfo.addStringPermissions(permissionSet);
        authorizationInfo.addRoles(roleSet);
        return authorizationInfo;
    }

}
