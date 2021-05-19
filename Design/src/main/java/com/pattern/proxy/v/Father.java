package com.pattern.proxy.v;

public class Father {

    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    public void findLove(){

        System.out.println("父母物色对象");
        son.findLove();
        System.out.println("双方同意交往 ， 确定关系");

    }
}
