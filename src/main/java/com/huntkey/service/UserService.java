package com.huntkey.service;

import com.huntkey.dto.JDBCDTO;
import com.huntkey.dto.TestBean;

/**
 * Created by liuwens on 2017/7/28.
 */
public interface UserService
{

    String getUserInfo();

    JDBCDTO getJDBCDTO();

    TestBean getTestBean();

}
