package com.second;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet({ "/RegisterServlet", "/register.do" })
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	  HttpSession session = request.getSession();
          String checkCode = (String) session.getAttribute("checkCode");

          String paramsName = request.getParameter("name");
          String paramsPwd = request.getParameter("pwd");
          String paramsCheckCode = request.getParameter("checkCode").trim();

          // do somethines

          //
          response.setContentType("text/html;charset=utf-8");
          if (checkCode.equalsIgnoreCase(paramsCheckCode)) {
              System.out.println("check code ok");
              response.getWriter().write(
                      "尊敬的 <bold>" + paramsName + "</bold>用户，您的密码为：" + paramsPwd
                              + "<br/>验证码 OK");
          } else {
              response.getWriter().write(
                      "尊敬的 <bold>" + paramsName + "</bold>用户，您的密码为：" + paramsPwd
                              + "<br/>验证码 not OK");
          }    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("checkCode");

        String paramsName = request.getParameter("name");
        String paramsPwd = request.getParameter("pwd");
        String paramsCheckCode = request.getParameter("checkCode").trim();

        // do somethines

        //
        response.setContentType("text/html;charset=utf-8");
        if (checkCode.equalsIgnoreCase(paramsCheckCode)) {
            System.out.println("check code ok");
            response.getWriter().write(
                    "尊敬的 <bold>" + paramsName + "</bold>用户，您的密码为：" + paramsPwd
                            + "<br/>验证码 OK");
        } else {
            response.getWriter().write(
                    "尊敬的 <bold>" + paramsName + "</bold>用户，您的密码为：" + paramsPwd
                            + "<br/>验证码 not OK");
        }
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}