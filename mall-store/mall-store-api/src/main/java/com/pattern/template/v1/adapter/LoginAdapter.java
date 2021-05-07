package com.pattern.template.v1.adapter;

import com.pattern.template.v1.ResultMsg;

public interface LoginAdapter {

    boolean support(Object adapter);

    ResultMsg login(String id, Object adapter);

}
