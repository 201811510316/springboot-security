package com.example.springbootsecurity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_permission")
public class sysPermission {

    @TableId(value="id",type = IdType.AUTO)
    private Integer id;
    private String url;
    @TableField(value="role_id")
    private Integer roleId;
    private String permission;


    public List<String> getPermissions() {
        return Arrays.asList(this.permission.trim().split(","));
    }

}
