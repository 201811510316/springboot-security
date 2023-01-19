package com.example.springbootsecurity.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootsecurity.dao.sysRoleMapper;
import com.example.springbootsecurity.pojo.sysRole;
import com.example.springbootsecurity.service.sysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sysRoleServiceImpl implements sysRoleService {

    @Autowired
    sysRoleMapper sysRoleMapper;

    @Override
    public sysRole selectById(Integer id) {
        return sysRoleMapper.selectById(id);
    }

    @Override
    public sysRole selectByName(String name) {
        QueryWrapper<sysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        return sysRoleMapper.selectOne(wrapper);
    }
}
