<%@ page import="com.Wuhaotian.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 26363
  Date: 2021/4/14
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Info</h1>
<%
    //Cookie [] allCookies=request.getCookies();
    //for(Cookie c:allCookies){
          //out.println("<br/>"+c.getName()+" --- "+c.getValue());
    User u=(User) session.getAttribute("user");
%>
<%
    //User user=(User)request.getAttribute("user");
%>
<table>

    <tr>
        <td>id:</td><td><%=u.getId()%></td>
    </tr>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td>
    </tr>
    <tr>
        <td>password:</td><td><%=u.getPassword()%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=u.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender:</td><td><%=u.getGender()%></td>
    </tr>
    <tr>
        <td>Birthdate:</td><td><%=u.getBirthdate()%></td>
    </tr>
    <tr>
        <td><a href="UpdateUser">Update</a></td>
    </tr>

</table>


<%@include file="footer.jsp"%>
