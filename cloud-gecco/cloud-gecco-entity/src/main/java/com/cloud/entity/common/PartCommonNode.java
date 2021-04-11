package com.cloud.entity.common;

/**
 * @Author zuyunbo
 * @Date 2021/4/9  9:29 上午
 **/
public class PartCommonNode {


    /**
     * BOM层级
     */
    private String bomLevel;


    /**
     * PV GUID
     */
    private String bomLineId;


    public String getBomLevel() {
        return bomLevel;
    }

    public void setBomLevel(String bomLevel) {
        this.bomLevel = bomLevel;
    }

    public String getBomLineId() {
        return bomLineId;
    }

    public void setBomLineId(String bomLineId) {
        this.bomLineId = bomLineId;
    }
}
