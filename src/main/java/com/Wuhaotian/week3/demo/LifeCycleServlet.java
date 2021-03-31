package com.Wuhaotian.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {
    //1.tomcat read wen.xml file and find out all servlet class
    //2.load servlet - when？ 2.first request for this servlet come in - form client
    //3.cll default constructor - add code
    public LifeCycleServlet(){

        System.out.println("i am in constructor --> LifeCycleServlet ()" );
    }
    //4.init() - add code
    public void init(){
        System.out.println("i am in init()");//line 2
    }
    //5.tomcat call service ()-->call doGet() or doPose()
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service ()-->doGet()");//line
        //line 4- 2nd request
        //line 5- 3nd request
        //and so on --many times - for each request
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //line 4- 2nd request
        // line5-3nd request
    }
    @Override
    public void destroy(){
        System.out.println("i am in destroy()");//when ? -stop tomcat
    }
}