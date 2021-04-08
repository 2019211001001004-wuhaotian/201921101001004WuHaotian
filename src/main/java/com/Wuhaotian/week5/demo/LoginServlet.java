package com.Wuhaotian.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name="LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;databaseName=userdb";
        String username="sa";
        String password="123456";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer=response.getWriter();
        try {
            String sql = "SELECT * FROM usertable WHERE username=? and password=?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, request.getParameter("username"));
            ps.setString(2, request.getParameter("password"));
            ResultSet resultset;
            resultset = ps.executeQuery();
            if(resultset.next())
                writer.println("Login Success!\n"+"Welcome"+request.getParameter("username"));
            else {
                writer.println("username or password error");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}
