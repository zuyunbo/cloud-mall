package com.cloud.entity.common;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author zuyunbo
 * @Date 2021/4/7  3:20 下午
 **/
public class PartCommonVersion {

    /**
     * 零件名称
     */
    private String partName;
    /**
     * 零件编号
     */
    private String partNumber;
    /**
     * 零件版本
     */
    private String partChangeIndex;
    /**
     * 图纸版本
     */
    private String drawingIndex;
    /**
     * 零件目标生效时间
     */
    private String partTid;

    /**
     * 零件变更单
     */
    private String changeNumberPartVersion;
    /**
     * 生产旧件处理
     */
    private String seriesDisposal;

    /**
     * 售后旧件处理
     */
    private String afterSalesDisposal;

    /**
     * 重量
     */
    private String weight;


    /**
     * 重量类型
     */
    private String weightType;


    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartChangeIndex() {
        return partChangeIndex;
    }

    public void setPartChangeIndex(String partChangeIndex) {
        this.partChangeIndex = partChangeIndex;
    }

    public String getDrawingIndex() {
        return drawingIndex;
    }

    public void setDrawingIndex(String drawingIndex) {
        this.drawingIndex = drawingIndex;
    }

    public String getPartTid() {
        return partTid;
    }

    public void setPartTid(String partTid) {
        this.partTid = partTid;
    }

    public String getChangeNumberPartVersion() {
        return changeNumberPartVersion;
    }

    public void setChangeNumberPartVersion(String changeNumberPartVersion) {
        this.changeNumberPartVersion = changeNumberPartVersion;
    }

    public String getSeriesDisposal() {
        return seriesDisposal;
    }

    public void setSeriesDisposal(String seriesDisposal) {
        this.seriesDisposal = seriesDisposal;
    }

    public String getAfterSalesDisposal() {
        return afterSalesDisposal;
    }

    public void setAfterSalesDisposal(String afterSalesDisposal) {
        this.afterSalesDisposal = afterSalesDisposal;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getWeightType() {
        return weightType;
    }

    public void setWeightType(String weightType) {
        this.weightType = weightType;
    }
}
