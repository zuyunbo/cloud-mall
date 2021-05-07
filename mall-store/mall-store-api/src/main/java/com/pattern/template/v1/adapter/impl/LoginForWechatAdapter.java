package com.pattern.template.v1.adapter.impl;

import com.pattern.template.v1.ResultMsg;
import com.pattern.template.v1.adapter.LoginAdapter;

public class LoginForWechatAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWechatAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
