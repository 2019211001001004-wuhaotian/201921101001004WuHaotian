package com.Wuhaotian.week5.demo;

import com.Wuhaotian.dao.UserDao;
import com.Wuhaotian.model.User;

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
        /*ServletContext servletContext = getServletContext();
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;databaseName=userdb";
        String username="sa";
        String password="123456";

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }*/
        con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =  request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null) {
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
            }else{
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        System.out.println(username+password);
        try {
            String sql = "SELECT * FROM usertable WHERE username=? and password=?";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ps.setString(1, request.getParameter("username"));
            ps.setString(2, request.getParameter("password"));
            ResultSet resultSet;
            resultSet = ps.executeQuery();
            if(resultSet.next())
            {
                //WEEK 5 CODE
                //writer.println("Login Success!\n"+"Welcome"+request.getParameter("username"));
            //else {
              //  writer.println("username or password error");
                request.setAttribute("Id",resultSet.getInt("id"));
                request.setAttribute("username",resultSet.getString("username"));
                request.setAttribute("password",resultSet.getString("password"));
                request.setAttribute("email",resultSet.getString("email"));
                request.setAttribute("gender",resultSet.getString("gender"));
                request.setAttribute("birthdate",resultSet.getString("birthdate"));

                request.getRequestDispatcher("userinfo.jsp").forward(request,response);

            }else {
//                PrintWriter writer = response.getWriter();
//                writer.println("Login Fail!!! ");
//                writer.println(" Wrong Password or Wrong Username ");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    private boolean LoginCheck(String username, String password) throws SQLException {
        String sql = "SELECT * FROM  usertable WHERE username =? and password =?";
        ResultSet resultSet;
        Statement stmt = con.createStatement();
        PreparedStatement ps;
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        resultSet = ps.executeQuery();
        if(resultSet.next()){
            resultSet.close();
            ps.close();
            stmt.close();
            return true;  //success
        }else {
            resultSet.close();
            ps.close();
            stmt.close();
            return false;  //fail
        }


    }

}

