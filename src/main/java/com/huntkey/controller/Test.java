package com.huntkey.controller;

import com.huntkey.dto.ApplicationDTO;
import com.huntkey.dto.JDBCDTO;
import com.huntkey.dto.TestBean;
import com.huntkey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by liuwens on 2017/7/28.
 */
@RestController
@RequestMapping("/kylin")
public class Test
{
    //@Resource(name = "userInfoService")


    @Autowired
    @Qualifier(value = "userInfoService")
    private UserService userService;



    @RequestMapping("/test")
    public TestBean test()
    {
        String userName = userService.getUserInfo();

        JDBCDTO obj = userService.getJDBCDTO();

        TestBean testBean = userService.getTestBean();


        return testBean;
    }

    @RequestMapping("/test2")
    public String test2()
    {
        String userName = userService.getUserInfo();

        JDBCDTO obj = userService.getJDBCDTO();

        TestBean testBean = userService.getTestBean();


        return userName;
    }


}
