package com.rpc.api;

public class HelloServiceImpl implements IHelloService{





    @Override
    public String sayHello(String content) {
        System.out.println("request int:" + content);
        return "say hello " + content;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("request save:" + user);
        return "success";
    }
}
