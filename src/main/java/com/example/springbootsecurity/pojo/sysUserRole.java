package com.example.springbootsecurity.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user_role")
public class sysUserRole {

    @TableField(value = "user_id")
    private Integer userId;
    @TableField(value="role_id")
    private Integer roleId;
}
