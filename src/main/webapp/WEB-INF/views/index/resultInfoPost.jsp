<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${applicationScope.appLang}" />
<fmt:setBundle basename="messages" var="message" />
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
    <thead>
    <tr>
        <th style="background-color: #eeeeee; text-align: center;">ID</th>
        <th style="background-color: #eeeeee; text-align: center;">Writer</th>
        <th style="background-color: #eeeeee; text-align: center;">Title</th>
        <th style="background-color: #eeeeee; text-align: center;">Time</th>
        <th style="background-color: #eeeeee; text-align: center;">View</th>
    </tr>
    </thead>
    <tbody>
    </th>
    <tr>
        <td>${postInfo.getId()}</td>
        <td>${postInfo.getUserId()}</td>
        <td>${postInfo.getTitle()}</td>
        <td>${postInfo.getWriteTime()}</td>
        <td>${postInfo.getViewCount()}</td>
    </tr>
    </tbody>
</table>
<a href="postPage.jsp"><fmt:message key="게시판메뉴페이지" bundle="${message}" /></a>
</body>
</html>

