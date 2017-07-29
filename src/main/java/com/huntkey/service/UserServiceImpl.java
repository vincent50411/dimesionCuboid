package com.huntkey.service;

import com.huntkey.dto.ApplicationDTO;
import com.huntkey.dto.JDBCDTO;
import com.huntkey.dto.TestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by liuwens on 2017/7/28.
 */
@Service(value = "userInfoService")
public class UserServiceImpl implements UserService
{
    @Autowired
    private ApplicationDTO applicationDTO;

    @Autowired
    @Qualifier("getTestBean")
    private TestBean testBean;

    @Override
    public String getUserInfo()
    {
        return applicationDTO.getOtherName() + "-->";
    }

    @Override
    public JDBCDTO getJDBCDTO()
    {


        return applicationDTO.getJdbc();
    }

    @Override
    public TestBean getTestBean()
    {
        return testBean;
    }
}
