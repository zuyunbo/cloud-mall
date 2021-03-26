package com.cloud.entity;

import java.util.Map;

/**
 * @Author zuyunbo
 * @Date 2021/3/16  3:46 下午
 **/
public class PartVersion {

    private PartVersionRelationship partVersionRelationship;

    private PartPropertyValueAssignment propertyValueAssignment;

    private Map<String,String> CharacterString;

    public PartVersionRelationship getPartVersionRelationship() {
        return partVersionRelationship;
    }

    public void setPartVersionRelationship(PartVersionRelationship partVersionRelationship) {
        this.partVersionRelationship = partVersionRelationship;
    }

    public PartPropertyValueAssignment getPropertyValueAssignment() {
        return propertyValueAssignment;
    }

    public void setPropertyValueAssignment(PartPropertyValueAssignment propertyValueAssignment) {
        this.propertyValueAssignment = propertyValueAssignment;
    }

    public Map<String, String> getCharacterString() {
        return CharacterString;
    }

    public void setCharacterString(Map<String, String> characterString) {
        CharacterString = characterString;
    }



}
