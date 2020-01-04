package com.example.mongoandmybatis.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class CustomRealm extends AuthorizingRealm {
    /**
     * 登录验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("---------这是身份验证方法------------");
        String username = (String) authenticationToken.getPrincipal();
        String userpsw = new String((char[]) authenticationToken.getCredentials());
        //根据用户名获取数据库中的密码
        String password = "123";
        if (username == null) {
            throw new AccountException("用户名不正确");
        } else if(!userpsw.equals(password)){
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(username, password,getName());
    }

    /**
     * 对已经成功登录的用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String principal = (String) SecurityUtils.getSubject().getPrincipal();
        return null;
    }


}
