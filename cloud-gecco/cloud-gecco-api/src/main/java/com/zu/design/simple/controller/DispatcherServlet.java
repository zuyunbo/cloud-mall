package com.zu.design.simple.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author zuyunbo
 * @Date 2021/5/6  4:25 下午
 **/
public class DispatcherServlet extends HttpServlet {

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uri = request.getRequestURI();

        String mid = request.getParameter("mid");

        if("getMemberById".equals(uri)){
            new MemberController().getMemberById(mid);
        }
        else if("getOrderById".equals(uri)){
            new OrderController().getOrderById(mid);
        }
        else if("logout".equals(uri)){
            new SystemController().logout();
        }
        else {
            response.getWriter().write("404 Not Found!!");
        }
    }

    @Override
    protected  void service(HttpServletRequest request, HttpServletResponse response){

        try {
            doDispatch(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
