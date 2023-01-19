package com.example.springbootsecurity.security;

import com.example.springbootsecurity.pojo.sysPermission;
import com.example.springbootsecurity.service.sysPermissionService;
import com.example.springbootsecurity.service.sysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

//权限管理
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    sysPermissionService sysPermissionService;
    @Autowired
    sysRoleService sysRoleService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        //获得loadUserByUsername()方法的结果
        User user=(User)authentication.getPrincipal();
        //获得loadUserByUsername()中注入的角色
        Collection<GrantedAuthority> authorities = user.getAuthorities();

        //遍历用户所有角色
        for(GrantedAuthority authority:authorities){
            String roleName = authority.getAuthority();
            Integer roleId = sysRoleService.selectByName(roleName).getId();
            //得到角色所有的权限
            List<sysPermission> permissionList = sysPermissionService.listByRoleId(roleId);

            //遍历权限
            for(sysPermission sysPermission:permissionList){
                //获取权限集
                List permissions = sysPermission.getPermissions();
                if(targetDomainObject.equals(sysPermission.getUrl()) && permissions.contains(targetDomainObject)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        return false;
    }
}
