package com.jzx.crowd.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jzx.crowd.constant.CrowdConstant;
import com.jzx.crowd.exception.LoginFailedException;
import com.jzx.crowd.mapper.AdminMapper;
import com.jzx.crowd.service.AdminService;
import com.jzx.crowd.util.CrowdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jzx.crowd.entity.Admin;
import com.jzx.crowd.entity.AdminExample;

import java.util.List;
import java.util.Objects;

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

    @Override
    public void saveAdmin(Admin admin) {

        adminMapper.insert(admin);
    }

    @Override
    public List<Admin> getAll() {
        return adminMapper.selectByExample(new AdminExample());
    }

    @Override
    public Admin getAdminByLoginAcct(String loginAcct, String password) {

        // 1 根据登陆账号查询Admin对象
        List<Admin> list = adminMapper.getAdminByLoginAcct(loginAcct);
        // 2 判断Admin对象是否为空
        if ( list == null || list.size() == 0 ){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        // ① 意外情况要防止查询到多个值
        if(list.size()>1){
            throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
        }
        // 3 如果Admin为空则抛出异常
        Admin admin = list.get(0);
        if(admin==null){
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        // 4 如果Admin对象不为null，则将从数据库中的账号密码拿出
        String userPasswordDB = admin.getUserPassword();
        // 5 将表单提交的明文密码password进行MD5加密
        String userPasswordFrom = CrowdUtil.md5(password);
        // 6 对两个密码进行比较(使用Object提供的方法可以防止这两个变量有空值造成异常)
        if(!Objects.equals(userPasswordFrom,userPasswordDB)){
            // 7 如果比较结果不一致则抛出异常
            throw new LoginFailedException(CrowdConstant.MESSAGE_LOGIN_FAILED);
        }
        // 8 如果一致则返回Admin对象
        return admin;
    }

    @Override
    public PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize) {

        // 1 先调用PageHelper的静态方法开启分页的功能
        // 这里充分体现了PageHelper的非侵入式设计 使得原本要做的查询不需要任何修改就可以完成分页
        PageHelper.startPage(pageNum,pageSize);

        // 2 执行查询
        List<Admin> list = adminMapper.selectAdminByKeyword(keyword);

        // 3 封装到PageInfo对象
        return new PageInfo<>(list);
    }
}
