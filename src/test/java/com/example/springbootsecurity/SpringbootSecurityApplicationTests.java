package com.example.springbootsecurity;

import com.example.springbootsecurity.dao.sysPermissionMapper;
import com.example.springbootsecurity.pojo.sysPermission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootSecurityApplicationTests {

    @Autowired
    sysPermissionMapper sysPermissionMapper;

    @Test
    void contextLoads() {
        List<sysPermission> sysPermissions = sysPermissionMapper.selectList(null);
        for(sysPermission sysPermission:sysPermissions){
            List<String> permissions = sysPermission.getPermissions();
            System.out.println(permissions);
        }
    }

}
