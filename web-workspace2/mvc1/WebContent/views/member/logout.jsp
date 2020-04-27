<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (session != null){
		// 세션 파기
		session.invalidate();
	} 
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/">메인 페이지로 이동</a><br>
	<a href="/views/member/login.jsp">로그인 페이지로 이동</a>
</body>
</html>