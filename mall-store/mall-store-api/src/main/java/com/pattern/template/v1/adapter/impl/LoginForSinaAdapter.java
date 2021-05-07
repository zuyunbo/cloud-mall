package com.pattern.template.v1.adapter.impl;

import com.pattern.template.v1.ResultMsg;
import com.pattern.template.v1.adapter.LoginAdapter;


/**
 * 新浪微博登陆Login
 *
 */
public class LoginForSinaAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof  LoginForSinaAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
