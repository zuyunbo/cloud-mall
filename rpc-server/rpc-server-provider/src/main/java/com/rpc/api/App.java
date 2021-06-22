package com.rpc.api;

public class App {

    public static void main(String[] args) {

        IHelloService iHelloService = new HelloServiceImpl();
        RpcProServer proServer = new RpcProServer();

        proServer.publisher(iHelloService,8080);


    }

}
