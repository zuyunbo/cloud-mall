package com.pattern.template.v1.adapter.impl;

import com.pattern.template.v1.ResultMsg;
import com.pattern.template.v1.adapter.LoginAdapter;


/**
 *
 * QQ登陆适配器
 */
public class LoginForQQAdapter implements LoginAdapter {


    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        System.out.println("QQ登陆");
        return null;
    }
}
