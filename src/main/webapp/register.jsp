<%--
  Created by IntelliJ IDEA.
  User: 26363
  Date: 2021/3/22
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<form method="post" action="register"><!--within doPost() in servlet-->
    This is my register JSP page.<br>
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender<input type="radio" name="gender" value="male">Male <input type="radio" name="gender" value="female">Female<br/>
    <!--if name is same it make array -->
    Date of Birth :<input type="text name=" name="birthDate"><br/>
    <input type="submit" value="Register"/>

</form>
<%@include file="footer.jsp"%>
