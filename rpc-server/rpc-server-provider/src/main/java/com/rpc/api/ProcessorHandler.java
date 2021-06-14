package com.rpc.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

public class ProcessorHandler implements Runnable{

    private Socket socket;

    private Object service;


    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {

        ObjectInputStream objectInputStream = null;

        ObjectOutputStream objectOutputStream = null;


        InputStream inputStream = null;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
            inputStream = socket.getInputStream();

            // 输入流应该有什么信息
            RpcRequest request  = (RpcRequest) objectInputStream.readObject();
            Object re = invoke(request);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(re);
            objectOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private Object invoke(RpcRequest request ){
        Object[] parameters = request.getParameters();

        Class<?>[] types = new Class[parameters.length];
        Object invoke = null;
        int i = 0;
        for(Object o :parameters ){
            types[i] = o.getClass();
            i++;
        }
        try {
            Class<?> aClass = Class.forName(request.getClassName());
            Method method = aClass.getMethod(request.getMethodName(), types);
            invoke = method.invoke(service, parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return invoke;

    }

}
