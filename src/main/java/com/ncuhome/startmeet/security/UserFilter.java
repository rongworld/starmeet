package com.ncuhome.startmeet.security;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


/*
 *验证用户是否登录
 * */

@WebFilter
@Slf4j
public class UserFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        log.info(httpServletRequest.getHeader("Authorization"));


        log.info(httpServletRequest.getMethod());
        log.info(httpServletRequest.getRemoteHost());


        if (httpServletRequest.getMethod().equals("OPTIONS")){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        if (Token.parseJWT(httpServletRequest.getHeader("Authorization"))){

            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            servletResponse.getWriter().append("{\"code\":-1,\"message\":\"Permission Denied\"}");
        }
    }

    @Override
    public void destroy() {


    }
}
