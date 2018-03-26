<%@page language="java" pageEncoding="utf-8" %>
<%
    String webContext = application.getContextPath();
    String contextPath = request.getContextPath();
%>
<%@taglib prefix="cf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<head>
    <h1>Register</h1>

    <form method="POST" commandName="spitter">
        First Name: <sf:input  path="firstName" /><br/>
        <%--<sf:errors path="firstName"/>--%>
        Last Name: <sf:input  path="lastName" /><br/>
        Email: <sf:input path="email" type="email"/><br/>
        Username: <sf:input path="username" /><br/>
        Password: <sf:input path="password" /><br/>
        <input type="submit" value="Register" />
    </form>

</head>
<body>
    <c:forEach items="${spittleList}" var="spittle">
        <li id="spittle_<c:out value="spittle.id"/>">
            <div>
                <c:out value="${spittle.time}"/>
            </div>
        </li>
    </c:forEach>
</body>
</html>
