package com.Wuhaotian.controller;

import com.Wuhaotian.dao.UserDao;
import com.Wuhaotian.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{

        // String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:databaseName=userdb";
        //String username="sa";
        //String password="1354437507cl";
        con = (Connection)getServletContext().getAttribute("con");


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        Date birthdate = Date.valueOf(request.getParameter("birthDate"));
        User user=new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthdate(birthdate);
        UserDao User=new UserDao();
        try {
            User.updateUser(con,user);
            HttpSession session= request.getSession();
            session.setMaxInactiveInterval(60*60);
            session.setAttribute("user",user);
            request.getRequestDispatcher("accountDetails").forward(request,response);
            //request.getRequestDispatcher("WEB-INF/views/userInfo.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
