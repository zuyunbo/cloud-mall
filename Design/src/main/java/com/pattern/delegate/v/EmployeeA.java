package com.pattern.delegate.v;

public class EmployeeA implements IEmployee{
    @Override
    public void doing(String command) {
        System.out.println("我是员工A.我现在开始于"+ command +"工作");
    }
}
