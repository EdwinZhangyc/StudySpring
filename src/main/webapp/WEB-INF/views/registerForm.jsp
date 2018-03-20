<%@page language="java" pageEncoding="utf-8" %>
<%
    String webContext = application.getContextPath();
    String contextPath = request.getContextPath();
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<html>
<head>
    <title>Spittr</title>

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
