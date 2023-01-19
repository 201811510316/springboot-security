package com.example.springbootsecurity.service;

import com.example.springbootsecurity.pojo.sysRole;

public interface sysRoleService {

    sysRole selectById(Integer id);

    sysRole selectByName(String name);
}
