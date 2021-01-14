package com.qianfeng.day22.util;

import com.qianfeng.day22.entity.Users;
import com.qianfeng.day22.service.AuthService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Resource
    private AuthService authService;

    // 表示与其他的realm区分
    @Override
    public String getName() {
        return "myRealm";
    }

    // 角色和权限查询操作
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 得到当前唯一的用户
        Users users =  (Users) principals.iterator().next();
        // 创建一个角色权限封装对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 得到所有的角色信息
        List<String> roleCode = authService.findRoleCodeByUserId(users.getId());
        info.setRoles(new HashSet<String>(roleCode));
        // 得到所有的权限信息
        List<String> authNames = authService.findAuthNameByUserId(users.getId());
        info.setStringPermissions(new HashSet<String>(authNames));

        return info;
    }

    // 登录操作
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 得到登录输入的用户名和密码
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        char[] chars = usernamePasswordToken.getPassword();
        String password = new String(chars);
        // 查询用户登录信息
        Users users = authService.findByUsernameAndPwd(username, password);
        // 将登录用户封装并返回（用户对象，密码，realm名称）
        return new SimpleAuthenticationInfo(users, password, getName());
    }
}
