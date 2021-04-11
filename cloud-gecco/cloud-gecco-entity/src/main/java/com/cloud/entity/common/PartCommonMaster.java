package com.cloud.entity.common;

/**
 * @Author zuyunbo
 * @Date 2021/4/7  3:26 下午
 **/
public class PartCommonMaster {

    /**
     * 零件名称
     */
    private String partName;


    /**
     * 零件编号
     */
    private String partNumber;

    /**
     * 零件归属标识
     */
    private String partOwnershipIndicator;


    /**
     * 数量单位
     */
    private String unit;


    /**
     * 关键字符
     */
    private String bmwCharacterKey;


    /**
     * 左右件标识
     */
    private String bmwLeftRightCharacteristics;

    /**
     * 对称件
     */
    private String symmetricPart;
    /**
     * 法规标识
     */
    private String legalRelevant;
    /**
     * 防静电标识
     */
    private String esdFlag;

    /**
     * 危险品标识
     */
    private String dangerousGoods;


    /**
     * 参考数模的零件号
     */
    private String bmwDmu;

    /**
     * 参考图纸的零件号
     */
    private String bmwDrawingHint;


    /**
     * 本色件号
     */
    private String allColorReference;



    /**
     * 零件状态
     */
    private String bmwReleaseStatus;


    /**
     * 颜色代码
     */
    private String colorCode;


    /**
     * 硬件/软件标识
     */
    private String bmwHwSwMark;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBmwCharacterKey() {
        return bmwCharacterKey;
    }

    public void setBmwCharacterKey(String bmwCharacterKey) {
        this.bmwCharacterKey = bmwCharacterKey;
    }

    public String getPartOwnershipIndicator() {
        return partOwnershipIndicator;
    }

    public void setPartOwnershipIndicator(String partOwnershipIndicator) {
        this.partOwnershipIndicator = partOwnershipIndicator;
    }

    public String getBmwLeftRightCharacteristics() {
        return bmwLeftRightCharacteristics;
    }

    public void setBmwLeftRightCharacteristics(String bmwLeftRightCharacteristics) {
        this.bmwLeftRightCharacteristics = bmwLeftRightCharacteristics;
    }

    public String getSymmetricPart() {
        return symmetricPart;
    }

    public void setSymmetricPart(String symmetricPart) {
        this.symmetricPart = symmetricPart;
    }

    public String getLegalRelevant() {
        return legalRelevant;
    }

    public void setLegalRelevant(String legalRelevant) {
        this.legalRelevant = legalRelevant;
    }

    public String getEsdFlag() {
        return esdFlag;
    }

    public void setEsdFlag(String esdFlag) {
        this.esdFlag = esdFlag;
    }

    public String getDangerousGoods() {
        return dangerousGoods;
    }

    public void setDangerousGoods(String dangerousGoods) {
        this.dangerousGoods = dangerousGoods;
    }

    public String getBmwDmu() {
        return bmwDmu;
    }

    public void setBmwDmu(String bmwDmu) {
        this.bmwDmu = bmwDmu;
    }

    public String getBmwDrawingHint() {
        return bmwDrawingHint;
    }

    public void setBmwDrawingHint(String bmwDrawingHint) {
        this.bmwDrawingHint = bmwDrawingHint;
    }

    public String getAllColorReference() {
        return allColorReference;
    }

    public void setAllColorReference(String allColorReference) {
        this.allColorReference = allColorReference;
    }

    public String getBmwReleaseStatus() {
        return bmwReleaseStatus;
    }

    public void setBmwReleaseStatus(String bmwReleaseStatus) {
        this.bmwReleaseStatus = bmwReleaseStatus;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public String getBmwHwSwMark() {
        return bmwHwSwMark;
    }

    public void setBmwHwSwMark(String bmwHwSwMark) {
        this.bmwHwSwMark = bmwHwSwMark;
    }
}
