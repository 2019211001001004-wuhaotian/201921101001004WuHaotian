<%--
  Created by IntelliJ IDEA.
  User: 26363
  Date: 2021/3/17
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">go to ecjtu</a><!-- method is GET-->
<form method="post"><!--what is method when we use form?--><!--its GET , why? default is GET,from data is added in the URL , ,u can see -->
<!-- its better to use POST in form , data in not added in the URL-->
    Name :<input type="text" name="Wuhaotian"><br/>
    ID :<input type="text" name="2019211001001004"><br/>
    <input type="submit" value="Send data to server"/>
</form>
</body>
</html>
