package com.Wuhaotian.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.*;

//automatic-new-->servlet
/*@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)*/
public class RegisterServlet extends HttpServlet {
    Connection con = null;//class variable

    @Override
    public void init() throws ServletException {
        /*ServletContext servletContext = getServletContext();
        String driver = servletContext.getInitParameter("driver");
        String url = servletContext.getInitParameter("url");
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        try {
            System.out.println(driver);
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println(con);
            System.out.println("init()-->" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
        //doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request come here-<from method=post>
        //get parameter from request
        //week3 code
        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");//name of input type-<input type="text" name="text" />
        String password = request.getParameter("password");//<input type="password" name="password" />
        String email = request.getParameter("email");//<input type="text" name="email" />
        String gender = request.getParameter("gender");//<input type="radio" name="gender">
        String birthdate = request.getParameter("birthdate");//<input type="text name=" name="birthday">

        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql = "insert into usertable(username,password,email,gender,birthdate) values(?,?,?,?,?);";
        System.out.println("n-->" + sql);
        int n = 0;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,gender);
            ps.setString(5,birthdate);
            ps.executeUpdate();
        //response.sendRedirect("login");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("n-->" + n);

        //String sql1 = "select id,username,password,email,gender,birthdate from usertable";
        //ResultSet rs = st.executeQuery(sql1);
        //PrintWriter out = response.getWriter();
        //out.println("<html><title></title><body><table border=1><tr>");
        //out.println("<td>Username</td><td>password</td><td>email</td><td>Gender</td><td>Birthdate</td><tr/>");
                /*while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("username") + "</td>");
                    out.println("<td>" + rs.getString("password") + "</td>");
                    out.println("<td>" + rs.getString("email") + "</td>");
                    out.println("<td>" + rs.getString("gender") + "</td>");
                    out.println("<td>" + rs.getString("birthdate") + "</td>");
                    out.println("</tr>");
                }*/
        //out.println("</table></body><html>");
        //request.setAttribute("name",rs);


        // request.getRequestDispatcher("userList.jsp").forward(request,response);//
        //url does not change
        //System.out.println("i am in RegisterServlet-->doPost()-->after forward()");
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            /*print-write into response
        PrintWriter writer = response.getWriter();
        writer.println("<br> username :"+username);
        writer.println("<br> password :"+password);
        writer.println("<br> email :"+email);
        writer.println("<br> gender :"+gender);
        writer.println("<br> birthday :"+birthday);
        writer.close();*/
        }
        }





