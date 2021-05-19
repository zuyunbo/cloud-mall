package com.pattern.delegate.v1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {


    private void doDispatch(HttpServletRequest request, HttpServletResponse response){
        String uri = request.getRequestURI();

        String mid = request.getParameter("MID");

        if("getMemberByID".equals(uri)){
            new MemberController().getMemberById(mid);
        }
        if("getOrderById".equals(uri)){
            new OrderController().getOrderById(mid);
        }
        if("logout".equals(uri)){
            new SystemController().logout();
        }
    }

    protected void service(HttpServletRequest request,HttpServletResponse response){
        doDispatch(request,response);
    }

}
