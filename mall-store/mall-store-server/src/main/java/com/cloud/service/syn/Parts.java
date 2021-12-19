package com.cloud.service.syn;

import java.util.List;

/**
 * @Author zuyunbo
 * @Date 2021/6/3  4:07 下午
 **/
public class Parts {

   private String beginTime;

   private String endTime;

   private List<String> cameraGBIds;


    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<String> getCameraGBIds() {
        return cameraGBIds;
    }

    public void setCameraGBIds(List<String> cameraGBIds) {
        this.cameraGBIds = cameraGBIds;
    }
}
