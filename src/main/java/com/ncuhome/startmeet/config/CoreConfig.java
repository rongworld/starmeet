package com.ncuhome.startmeet.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
*
* 解决跨域问题*/
//@WebFilter
public class CoreConfig implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        httpServletResponse.setHeader("Access-Control-Allow-Method","GET,POST,OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers","Authorization,Accept,Accept-Encoding,Accept-Language,User-Agent,Access-Control-Request-Headers,Access-Control-Request-Method,Cache-Control,Content-Type,Connection,Origin,User-Agent");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials","true");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
