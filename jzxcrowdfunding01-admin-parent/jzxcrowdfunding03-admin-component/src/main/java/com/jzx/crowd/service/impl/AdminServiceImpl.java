package com.jzx.crowd.service.impl;

import com.jzx.crowd.mapper.AdminMapper;
import com.jzx.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.crowd.entity.Admin;
import test.crowd.entity.AdminExample;

import java.util.List;

/**
 * @title: AdminServiceImpl
 * @Author Jzxxxx
 * @Date: 2020/9/16 21:46
 * @Version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private  AdminMapper adminMapper;

    public void saveAdmin(Admin admin) {

        adminMapper.insert(admin);
    }

    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }
}
