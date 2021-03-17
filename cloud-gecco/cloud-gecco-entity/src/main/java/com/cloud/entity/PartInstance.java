package com.cloud.entity;

import java.util.List;

/**
 * @Author zuyunbo
 * @Date 2021/3/16  3:44 下午
 **/
public class PartInstance {

      private String partId;

      private String partType;

      private List<PartVersion> partVersion;

      private PartPropertyValueAssignment propertyValueAssignment;

      public String getPartId() {
            return partId;
      }

      public void setPartId(String partId) {
            this.partId = partId;
      }

      public String getPartType() {
            return partType;
      }

      public void setPartType(String partType) {
            this.partType = partType;
      }

      public List<PartVersion> getPartVersion() {
            return partVersion;
      }

      public void setPartVersion(List<PartVersion> partVersion) {
            this.partVersion = partVersion;
      }

      public PartPropertyValueAssignment getPropertyValueAssignment() {
            return propertyValueAssignment;
      }

      public void setPropertyValueAssignment(PartPropertyValueAssignment propertyValueAssignment) {
            this.propertyValueAssignment = propertyValueAssignment;
      }
}
