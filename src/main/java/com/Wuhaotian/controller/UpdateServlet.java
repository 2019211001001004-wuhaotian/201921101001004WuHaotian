package com.Wuhaotian.controller;

import com.Wuhaotian.dao.UserDao;
import com.Wuhaotian.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateServlet", value = "/UpdateUser")
public class UpdateServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user1=new User();
        String id=request.getParameter("id");
        String Username=request.getParameter("username");
        String Password=request.getParameter("password");
        String Email=request.getParameter("email");
        String Gender=request.getParameter("gender");
        Date Birthdate = Date.valueOf(request.getParameter("birthDate"));
        //System.out.println(Birthdate);
        user1.setId(Integer.parseInt(id));
        user1.setUsername(Username);
        user1.setPassword(Password);
        user1.setEmail(Email);
        user1.setGender(Gender);
        user1.setBirthdate(Birthdate);
        //System.out.println(user1.getBirthdate());
        UserDao userDao1=new UserDao();
        try {
            PrintWriter out= response.getWriter();
            int User=userDao1.updateUser(con,user1);
            if (User>0){
                out.println("you correct update!!!");
            }else{
                out.println("fail update!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
