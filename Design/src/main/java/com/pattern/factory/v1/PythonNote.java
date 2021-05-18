package com.pattern.factory.v1;

public class PythonNote implements INote{
    @Override
    public void edit() {
        System.out.println("编写Python笔记");
    }
}
