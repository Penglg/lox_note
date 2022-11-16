package com.laigaopeng.www.interceptor;

import com.laigaopeng.www.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 登录操作放行
        if (request.getRequestURI().contains("users/login")) return true;


        User user = (User) session.getAttribute("user");
        if (user == null) {
            // 跳转登陆页面
            response.sendRedirect(request.getScheme() + "://" + request.getServerName()
                    + ":" + request.getServerPort() + '/'+"index.jsp");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
