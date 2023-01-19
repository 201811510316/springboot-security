package com.example.springbootsecurity.security;

import cn.hutool.core.util.ObjectUtil;
import com.example.springbootsecurity.pojo.sysRole;
import com.example.springbootsecurity.pojo.sysUser;
import com.example.springbootsecurity.pojo.sysUserRole;
import com.example.springbootsecurity.service.sysRoleService;
import com.example.springbootsecurity.service.sysUserRoleService;
import com.example.springbootsecurity.service.sysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//自定义userDetailsService
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    sysUserService sysUserService;

    @Autowired
    sysRoleService sysRoleService;

    @Autowired
    sysUserRoleService sysUserRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //获取用户信息
        sysUser sysUser = sysUserService.selectByName(username);

        if(ObjectUtil.isEmpty(sysUser)){
            throw new UsernameNotFoundException("用户不存在");
        }

        //添加角色
        List<sysUserRole> sysUserRoles = sysUserRoleService.listByUserId(sysUser.getId());
        for(sysUserRole userRole:sysUserRoles){
            sysRole sysRole = sysRoleService.selectById(userRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(sysRole.getName()));
        }

        return new User(sysUser.getName(),sysUser.getPassword(),authorities);
    }
}
