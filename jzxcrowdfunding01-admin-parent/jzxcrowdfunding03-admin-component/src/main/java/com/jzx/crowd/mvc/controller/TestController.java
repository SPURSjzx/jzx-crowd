package com.jzx.crowd.mvc.controller;

import com.jzx.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import test.crowd.entity.Admin;

import java.util.List;

/**
 * @title: TestController
 * @Author Jzxxxx
 * @Date: 2020/9/16 23:08
 * @Version 1.0
 */
@Controller
public class TestController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap){
        List<Admin> list = adminService.getAll();
        modelMap.put("list",list);
        return "target";
    }
}
