package com.jzx.crowd.mvc.interceptor;

import com.jzx.crowd.constant.CrowdConstant;
import com.jzx.crowd.entity.Admin;
import com.jzx.crowd.exception.AccessForbiddenException;
import com.jzx.crowd.mvc.config.CrowdExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @title: LoginInterceptor
 * @Author Jzxxxx
 * @Date: 2020/9/21 22:49
 * @Version 1.0
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 1.通过request获取session对象
        HttpSession session = httpServletRequest.getSession();
        // 2.然后获取Admin
        Admin admin = (Admin) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);
        // 3.是否为空
        if (admin == null){
            // 4.抛出异常
            throw new AccessForbiddenException(CrowdConstant.MESSAGE_ACCESS_FORBIDEN);
        }
        // 5.不为空true放行
        return true;
    }


}
