package com.pattern.adapter.v1;

public class SigninForThirdService extends SiginService{

    public ResultMsg loginForQQ(String openId){
        return this.loginForRegist(openId,null);
    }




    public ResultMsg loginForRegist(String username,String password){
        super.regist(username,password);
        return super.login(username,password);
    }

}
