package com.jzx.crowd.mvc.controller;

import com.jzx.crowd.constant.CrowdConstant;
import com.jzx.crowd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.jzx.crowd.entity.Admin;

import javax.servlet.http.HttpSession;

/**
 * @title: AdminController
 * @Author Jzxxxx
 * @Date: 2020/9/19 22:55
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/do/login.html")
    public String doLogin(@RequestParam("loginAcct")String loginAcct,
                          @RequestParam("password")String password,
                          HttpSession session){
        // 调用Service层的方法执行登陆检查
        // 这个方法如果返回admin对象说明登陆成功 如果账号密码异常则会抛出异常（在Service层会进行处理）
        Admin admin = adminService.getAdminByLoginAcct(loginAcct,password);

        // 将登录成功返回的admin对象存入Session
        // 在CrowdConstant中创建public static final String ATTR_NAME_LOGIN_ADMIN = "admin" 方便使用
        System.out.println(admin);
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,admin);
        System.out.println(session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN));
        // 为了防止跳转到页面后台主页面再刷新浏览器是会再次提交表单，我们需要重定向到目标页面，又因为不能直接访问web-inf下的页面，所以我们要么在使用一个controller或者去mvc.xnk中定义一个view-controller
        return "redirect:/admin/to/main/page.html";
    }

    @RequestMapping("/do/logout.html")
    public String login(HttpSession session){
        // 强制Session失效
        session.invalidate();
        // 重定向到登陆
        return "redirect:/admin/to/login/page.html";
    }
}
