package com.example.springbootsecurity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootsecurity.pojo.sysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface sysUserMapper extends BaseMapper<sysUser> {
}
