<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	소속 : ${sessionScope.member.companyName } <br>
	아이디 : ${sessionScope.member.memberId } <br>
	이름 : ${sessionScope.member.memberName } <br>
	전번 : ${sessionScope.member.phone } <br>
	회원등급 : ${sessionScope.member.memberLevel }
</body>
</html>