package com.rpc.api;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RpcProServer {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void  publisher(Object server, int port){

        ServerSocket serverSocket = null;


        try {
            serverSocket = new ServerSocket(port);
            while (true){
                Socket accept = serverSocket.accept();

                executorService.execute(new ProcessorHandler(accept,server));
            }



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
