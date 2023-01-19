package com.example.springbootsecurity.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootsecurity.dao.sysUserMapper;
import com.example.springbootsecurity.pojo.sysUser;
import com.example.springbootsecurity.service.sysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sysUserServiceImpl implements sysUserService {

    @Autowired
    sysUserMapper sysUserMapper;

    @Override
    public sysUser selectById(Integer id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public sysUser selectByName(String name) {
        QueryWrapper<sysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        return sysUserMapper.selectOne(wrapper);
    }
}
