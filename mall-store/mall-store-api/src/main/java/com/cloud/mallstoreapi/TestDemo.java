package com.cloud.mallstoreapi;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author zuyunbo
 * @Date 2021/6/22  2:06 下午
 **/
public class TestDemo {

    ClassLoader classLoader = new ClassLoader() {
        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
            InputStream is = getClass().getResourceAsStream(fileName);

            if (is == null) {
                return super.loadClass(name);
            }
            try {
                byte[] bytes = new byte[is.available()];
                is.read(bytes); //通过自定义类加载器读取class文件的二进制流
                return defineClass(name, bytes, 0, bytes.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.loadClass(name);
        }
    };

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        TestDemo testDemo = new TestDemo();
        Object obj = testDemo.classLoader.loadClass("com.cloud.mallstoreapi.FunctionTest").newInstance();

        FunctionTest functionTest = new FunctionTest();
        System.out.println(FunctionTest.class);
        System.out.println(FunctionTest.class);
        System.out.println(functionTest instanceof FunctionTest);
    }

}
