package com.spring.controller;

import com.spring.annotations.GAutowired;
import com.spring.annotations.GController;
import com.spring.annotations.GRequestMapping;
import com.spring.annotations.GRequestParam;
import com.spring.service.IDemoService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@GController
@GRequestMapping("/demo")
public class DemoAction {

    @GAutowired
    private IDemoService demoService;

    @GRequestMapping("/query")
    public void query(HttpServletRequest req, HttpServletResponse resp, @GRequestParam("name") String name) {
        String result = demoService.get(name);
        try {
            resp.getWriter().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GRequestMapping("/add")
    public void add(HttpServletRequest req, HttpServletResponse resp, @GRequestParam("a") Integer a, @GRequestParam("b") Integer b) {
        try {
            resp.getWriter().write(a + "+" + b + "=" + (a + b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GRequestMapping("/remove")
    public void remove(HttpServletRequest req, HttpServletResponse resp, @GRequestParam("id") Integer id) {
    }

}
