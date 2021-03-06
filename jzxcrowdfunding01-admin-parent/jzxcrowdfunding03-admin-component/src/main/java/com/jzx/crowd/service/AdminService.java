package com.jzx.crowd.service;

import com.github.pagehelper.PageInfo;
import com.jzx.crowd.entity.Admin;

import java.util.List;

/**
 * @title: AdminService
 * @Author Jzxxxx
 * @Date: 2020/9/16 21:00
 * @Version 1.0
 */

public interface AdminService {

    /**
     * 保存一个管理员
     * @param admin
     */
    void saveAdmin(Admin admin);

    List<Admin> getAll();

    Admin getAdminByLoginAcct(String loginAcct, String password);

    PageInfo<Admin> getPageInfo(String keyword,Integer pageNum,Integer pageSize);
}
