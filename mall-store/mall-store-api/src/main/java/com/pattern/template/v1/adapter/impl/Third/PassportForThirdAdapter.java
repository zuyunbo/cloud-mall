package com.pattern.template.v1.adapter.impl.Third;

import com.pattern.template.v1.ResultMsg;
import com.pattern.template.v1.SiginService;
import com.pattern.template.v1.adapter.LoginAdapter;
import com.pattern.template.v1.adapter.impl.LoginForQQAdapter;

/**
 * SiginService Tradition login
 *
 *
 */
public class PassportForThirdAdapter extends SiginService implements IPassportForThird{
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginForQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForTelPhone(String id) {
        return null;
    }

    @Override
    public ResultMsg loginForRegist(String id) {
        return null;
    }


    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz){
        try {
            LoginAdapter loginAdapter = clazz.newInstance();
            if(loginAdapter.support(loginAdapter)){
              return  loginAdapter.login(key,loginAdapter);
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
