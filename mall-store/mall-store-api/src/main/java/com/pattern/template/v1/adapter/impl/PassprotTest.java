package com.pattern.template.v1.adapter.impl;

import com.pattern.template.v1.adapter.impl.Third.IPassportForThird;
import com.pattern.template.v1.adapter.impl.Third.PassportForThirdAdapter;

public class PassprotTest {

    public static void main(String[] args) {

        IPassportForThird  iPassportForThird = new PassportForThirdAdapter();
        iPassportForThird.loginForQQ("1");

    }

}
