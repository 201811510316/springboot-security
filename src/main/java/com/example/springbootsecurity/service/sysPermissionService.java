package com.example.springbootsecurity.service;

import com.example.springbootsecurity.pojo.sysPermission;

import java.util.List;

public interface sysPermissionService {

    //获取指定角色所有权限
    List<sysPermission> listByRoleId(Integer roleId);
}
