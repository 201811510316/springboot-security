package com.example.springbootsecurity.service;

import com.example.springbootsecurity.pojo.sysUserRole;

import java.util.List;

public interface sysUserRoleService {

    List<sysUserRole> listByUserId(Integer userId);
}
