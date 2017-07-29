package com.huntkey.dto;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by liuwens on 2017/7/28.
 */
@Component
@ConfigurationProperties(prefix = "kylin", ignoreUnknownFields = false)
public class ApplicationDTO
{
    @Value("${test.className}")
    private String className;

    @Value("#{testBean.getTestName()}")
    private String otherName;

    private String userName;

    private JDBCDTO jdbc;

    private String testName;

    private String testURL;


    public String getOtherName() {
        return otherName;
    }

    public String getClassName() {
        return className;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestURL() {
        return testURL;
    }

    public void setTestURL(String testURL) {
        this.testURL = testURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public JDBCDTO getJdbc() {
        return jdbc;
    }

    public void setJdbc(JDBCDTO jdbc) {
        this.jdbc = jdbc;
    }

    @Bean("getTestDTO_002")
    public TestDTO_002 getTestDTO_002()
    {
        TestDTO_002 obj = new TestDTO_002();
        obj.setTestName("刘文生");

        return obj;
    }

    @Bean("getTestBean")
    public TestBean getTestBean()
    {
        TestBean testBean = new TestBean();
        testBean.setTestName(getTestName());
        testBean.setTestURL(getTestURL() + "+++++++++++++++++++++");

        return testBean;
    }


}
