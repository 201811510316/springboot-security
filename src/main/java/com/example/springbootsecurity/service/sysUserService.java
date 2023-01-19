package com.example.springbootsecurity.service;

import com.example.springbootsecurity.pojo.sysUser;

public interface sysUserService {

    sysUser selectById(Integer id);
    sysUser selectByName(String name);
}
