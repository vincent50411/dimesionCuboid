package com.huntkey.service;

import com.huntkey.dto.JDBCDTO;
import com.huntkey.dto.TestBean;
import org.springframework.stereotype.Service;

/**
 * Created by liuwens on 2017/7/28.
 */
@Service(value = "employInfoService")
public class EmployService implements UserService {
    @Override
    public String getUserInfo() {
        return null;
    }

    @Override
    public JDBCDTO getJDBCDTO() {
        return null;
    }

    @Override
    public TestBean getTestBean() {
        return null;
    }
}
