package com.example.springbootsecurity.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootsecurity.dao.sysPermissionMapper;
import com.example.springbootsecurity.pojo.sysPermission;
import com.example.springbootsecurity.service.sysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sysPermissionServiceImpl implements sysPermissionService {

    @Autowired
    sysPermissionMapper sysPermissionMapper;

    @Override
    public List<sysPermission> listByRoleId(Integer roleId) {
        QueryWrapper<sysPermission> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        return sysPermissionMapper.selectList(wrapper);
    }
}
