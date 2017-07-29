package com.huntkey.dto;

/**
 * Created by liuwens on 2017/7/29.
 */
public class DimesionDTO
{

    private String dimesionName;

    private int dimesionLevelValue;

    public DimesionDTO(String dimesionName, int dimesionLevelValue)
    {
        this.dimesionName = dimesionName;
        this.dimesionLevelValue = dimesionLevelValue;
    }

    public String getDimesionName() {
        return dimesionName;
    }

    public void setDimesionName(String dimesionName) {
        this.dimesionName = dimesionName;
    }

    public int getDimesionLevelValue() {
        return dimesionLevelValue;
    }

    public void setDimesionLevelValue(int dimesionLevelValue) {
        this.dimesionLevelValue = dimesionLevelValue;
    }
}
