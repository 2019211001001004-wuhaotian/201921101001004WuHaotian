package com.Wuhaotian.week6.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/Redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //redirect-same server - Relative URL
        //1.start without /
        System.out.println("before redirect");

        //response.sendRedirect( "index.jsp");//url-change to index.jsp
        //http://localhost:8080/201921101001004WuHaotian_war_exploded/redirect
        //http://localhost:8080/201921101001004WuHaotian_war_exploded/index.jsp
        //see the url - only last part of the url change(redirect --> index.jsp)
        System.out.println("after redirect");
        //2.start with /
        //response.sendRedirect("/201921101001004WuHaotian_war_exploded/index.jsp");//-???-HTTP STATUS 404 -NOT FOUND
        //why? - look at the url
        //http://localhost:8080/201921101001004WuHaotian_war_exploded/redirect
        //http://localhost:8080/index.jsp
        //url change after 8080 - means tomcat
        //add /201921101001004WuHaotian_war_exploded/

        //redirect - another server - Absolute URL -full url
        response.sendRedirect("https://www.baidu.com/");
        //Https://www.baidu.com/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
    }
}
