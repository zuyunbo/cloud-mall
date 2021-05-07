package com.pattern.template.v1;

public class SigninForThirdService extends SiginService {



    public ResultMsg loginForQQ(String openId){

        return loginForRegist(openId,null);

    }

    public ResultMsg loginForWechat(String openId){

        return loginForRegist(openId,null);

    }

    public ResultMsg loginForToken(String openId){

        return loginForRegist(openId,null);

    }

    public ResultMsg loginForTelphone(String openId){

        return loginForRegist(openId,null);

    }




    public ResultMsg loginForRegist(String username, String password) {

        super.regist(username, password);
        return super.login(username, null);

    }

}
