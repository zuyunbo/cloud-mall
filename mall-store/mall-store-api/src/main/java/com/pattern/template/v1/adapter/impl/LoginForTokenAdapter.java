package com.pattern.template.v1.adapter.impl;


import com.pattern.template.v1.ResultMsg;
import com.pattern.template.v1.adapter.LoginAdapter;

/**
 * 电话登陆
 */
public class LoginForTokenAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTokenAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
