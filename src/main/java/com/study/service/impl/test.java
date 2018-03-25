package com.study.service.impl;

import com.study.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class test {


    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-myBaties.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);

        test test = new test();
    }
}
