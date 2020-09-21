package com.jzx.crowd.test;

import com.jzx.crowd.mapper.AdminMapper;
import com.jzx.crowd.service.AdminService;
import com.jzx.crowd.util.CrowdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.jzx.crowd.entity.Admin;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @title: test.com.jzx.crowd.test.CrowdTest
 * @Author Jzxxxx
 * @Date: 2020/9/15 22:19
 * @Version 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-persist-mybatis.xml")
public class CrowdTest {

    @Qualifier(value = "dataSource")
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void testAdmin(){
        adminService.saveAdmin(new Admin(null,"lucy","123","lucy","1239546178@qq.com",null));
        System.out.println(adminService);
    }

    @Test
    public void testGetAdmin(){
        List<Admin> tom = adminMapper.getAdminByLoginAcct("tom");
        System.out.println(tom.size());
    }

    @Test
    public void testMD5(){
        String s = CrowdUtil.md5("123");
        System.out.println(s);
    }

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testInset(){
        Admin admin = new Admin(null, "tom", "123", "tom", "2329968598@qq.com", null);
        int insert = adminMapper.insert(admin);
        System.out.println(insert);
    }

}
