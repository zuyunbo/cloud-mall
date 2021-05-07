package com.pattern.template.v1.adapter.impl.Third;

import com.pattern.template.v1.ResultMsg;

public interface IPassportForThird {

    ResultMsg loginForQQ(String id);

    ResultMsg loginForWechat(String id);

    ResultMsg loginForToken(String id);

    ResultMsg loginForTelPhone(String id);

    ResultMsg loginForRegist(String id);



}
