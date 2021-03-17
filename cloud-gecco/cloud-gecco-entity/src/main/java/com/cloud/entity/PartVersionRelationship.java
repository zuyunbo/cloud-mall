package com.cloud.entity;

/**
 * @Author zuyunbo
 * @Date 2021/3/16  3:50 下午
 **/
public class PartVersionRelationship {

    private String relatedId;

    private String relationType;

    private PartPropertyValueAssignment propertyValueAssignment;

    public String getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(String relatedId) {
        this.relatedId = relatedId;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public PartPropertyValueAssignment getPropertyValueAssignment() {
        return propertyValueAssignment;
    }

    public void setPropertyValueAssignment(PartPropertyValueAssignment propertyValueAssignment) {
        this.propertyValueAssignment = propertyValueAssignment;
    }
}
