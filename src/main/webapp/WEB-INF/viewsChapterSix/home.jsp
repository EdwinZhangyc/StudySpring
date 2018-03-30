<%--<%@page language="java" pageEncoding="utf-8" %>--%>
<%--<%--%>
    <%--String webContext = application.getContextPath();--%>
    <%--String contextPath = request.getContextPath();--%>
<%--%>--%>

<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<%--<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>

<%--<meta charset="utf-8" />--%>
<%--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">--%>
<%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--<html>--%>
    <%--<head>--%>
        <%--<title>Spittr</title>--%>
    <%--</head>--%>
    <%--<body>--%>
        <%--<h1>Welcome to Spittr</h1>--%>
        <%--&lt;%&ndash;<h1><s:message code="spittr.welcome"/></h1>&ndash;%&gt;--%>

        <%--<a href="<c:url value="/spittles"/>">Spittles</a>--%>
        <%--<a href="<c:url value="/spittler/register"/>">Register</a>--%>
    <%--</body>--%>
<%--</html>--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<h1>Welcome to Spitter</h1>

<a href="<c:url value="/spittles" />">Spittles</a> |
<a href="<c:url value="/spittler/register" />">Register</a>
