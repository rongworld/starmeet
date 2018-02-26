package com.ncuhome.startmeet.security;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter
public class UserFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        if (CheckToken.parseJWT(httpServletRequest.getHeader("authorization"))){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            servletResponse.getWriter().append("{\"code\":-1,\"message\":\"Permission Denied\"}");
        }

    }

    @Override
    public void destroy() {


    }
}
