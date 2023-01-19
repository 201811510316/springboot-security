package com.example.springbootsecurity.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootsecurity.dao.sysUserRoleMapper;
import com.example.springbootsecurity.pojo.sysUserRole;
import com.example.springbootsecurity.service.sysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sysUserRoleServiceImpl implements sysUserRoleService {

    @Autowired
    sysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<sysUserRole> listByUserId(Integer userId) {
        QueryWrapper<sysUserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        return sysUserRoleMapper.selectList(wrapper);
    }
}
