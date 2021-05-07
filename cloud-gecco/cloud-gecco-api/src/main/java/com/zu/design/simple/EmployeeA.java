package com.zu.design.simple;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  4:16 下午
 **/
public class EmployeeA implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("我是员工A,现在我要开始干了"+command+"工作");
    }
}
