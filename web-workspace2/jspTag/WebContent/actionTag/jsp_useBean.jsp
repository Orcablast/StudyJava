<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="m" class="test.model.vo.Member" scope="page">
	<jsp:setProperty property="id" name="m" value="user1"/>
	<jsp:setProperty property="pw" name="m" value="pass1"/>
	<jsp:setProperty property="name" name="m" value="유저1"/>
	</jsp:useBean>
	<h1>jsp:useBean</h1>
	ID : <jsp:getProperty property="id" name="m"/><br/>
	PW : <jsp:getProperty property="pw" name="m"/><br/>
	NAME : <jsp:getProperty property="name" name="m"/><br/>
</body>
</html>