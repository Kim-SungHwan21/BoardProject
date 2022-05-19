<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>관리자 페이지</title>
</head>
<body>
<table method="post" action="/adminPage.do">
<h1>관리자 페이지</h1>
<hr>
<input type="button" value="로그아웃" onclick="location.href='/logout.do'"><br>
<a href="list.jsp">전체회원목록</a><br>
<a href="info.jsp">회원정보조회</a><br>
<a href="update.jsp">회원정보수정</a><br>
<a href="delete.jsp">회원정보삭제</a><br>
<a href="addUser.jsp">사용자추가</a><br>
</table>
<a href="index.jsp">NHN게시판웹사이트</a>
</body>
</html>

