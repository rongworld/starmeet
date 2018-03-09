package com.ncuhome.startmeet.config;

import com.google.inject.servlet.GuiceFilter;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebFilter;
/*
* GuiceFilter
* */
@WebFilter
@Configuration
public class SpringAwareGuiceFilter extends GuiceFilter{
}
