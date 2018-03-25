package com.study.service.impl;

import com.study.domain.User;
import com.study.service.UserService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.logging.Logger;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:Spring-myBaties.xml"})
public class userServiceImplTest extends TestCase {
    private  static Logger logger = Logger.getLogger("userServiceImplTest.class");

    @Autowired
    private UserService userService;

    @Test
    public void getUserInfo() {
        User user = userService.getUserInfo("test");
        logger.info("密码为" );
    }
}