package com.aaa.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHandler implements HandlerInterceptor {
    /*01.preHandle 如果返回值是false,则不会执行后续的操作！ 一个拦截器
    preHandle如果返回值是true 则会执行下一个拦截器
    02.如果有多个拦截器，则之后拦截器中的所有方法都不会执行！*/
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /*获取到请求的路径*/
        String url = httpServletRequest.getRequestURI();
        /*凡是和登录有关的路径直接放行*/
        if (url.indexOf("/Login")>-1){
            return true;
        }
        /*如果没有与登录有关的路径则判断Session中是否有用户的值*/
        HttpSession session = httpServletRequest.getSession();
        String username = (String)session.getAttribute("username");
        /*如果有值就放行*/
        if (username!=null){
            return true;
        }
        /*如果没有则拦截并返回到登录界面*/
        httpServletRequest.setAttribute("msg","请登录后在访问界面");
        httpServletRequest.getRequestDispatcher("/Login/Loginjsp").forward(httpServletRequest,httpServletResponse);
        return false;
    }

    /*之后指定了对应Handler中的方法之后 才执行！*/
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /*只要是当前拦截器中的preHandle返回true则此方法必须执行！
    *
    * */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
