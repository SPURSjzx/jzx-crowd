package com.jzx.crowd.mvc.controller;

import com.jzx.crowd.service.AdminService;
import com.jzx.crowd.util.CrowdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jzx.crowd.entity.Admin;

import javax.servlet.http.HttpServletRequest;
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
    public String testSsm(ModelMap modelMap, HttpServletRequest request){
        boolean b = CrowdUtil.judgeRequestType(request);
        System.out.println(b);
        List<Admin> list = adminService.getAll();
        int i = 10/0;
        modelMap.put("list",list);
        return "target";
    }
    @RequestMapping("/send/array.html")
    public String testReceiveArrayOne(@RequestParam("array[]")List<Integer> array){
        for (Integer integer : array) {
            System.out.println("number"+integer);
        }
        return null;
    }

}
