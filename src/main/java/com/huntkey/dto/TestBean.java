package com.huntkey.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by liuwens on 2017/7/28.
 */
@Component
@ConfigurationProperties(prefix = "kylin")
public class TestBean
{

    private String testName;

    private String testURL;


    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestURL() {
        return testURL + "===========================";
    }

    public void setTestURL(String testURL) {
        this.testURL = testURL;
    }
}
