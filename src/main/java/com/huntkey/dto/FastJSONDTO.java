package com.huntkey.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by liuwens on 2017/7/29.
 */
public class FastJSONDTO
{
    @JSONField(name = "prod_name_xxx")
    private String prodName;


    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
}
