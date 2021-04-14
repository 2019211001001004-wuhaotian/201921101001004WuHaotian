<%--
  Created by IntelliJ IDEA.
  User: 26363
  Date: 2021/4/7
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
    //error
    out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="loginServlet">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    <input type="submit" value="login"/>
</form>

<%@include file="footer.jsp"%>
