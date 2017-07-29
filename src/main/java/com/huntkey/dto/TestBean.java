package com.huntkey.dto;

import com.alibaba.fastjson.annotation.JSONField;
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

    @JSONField(name = "test_name")
    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @JSONField(name = "test_URL")
    public String getTestURL() {
        return testURL + "===========================";
    }

    public void setTestURL(String testURL) {
        this.testURL = testURL;
    }
}
