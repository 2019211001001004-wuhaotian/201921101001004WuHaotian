package com.Wuhaotian.week6.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext Context = sce.getServletContext();
        String driver = Context.getInitParameter("driver");
        String url = Context.getInitParameter("url");
        String username = Context.getInitParameter("username");
        String password = Context.getInitParameter("password");
        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("i am in contextInitialized()-->"+con);
            //System.out.println("init()-->" + con);
            Context.setAttribute("con",con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    //end point of web app
    System.out.println("i am in contextDestroyed()");
    sce.getServletContext().removeAttribute("con");
    }
}
