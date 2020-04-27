<%@page import="kh.java.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member member = (Member) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<hr />
	<form action="/updateMember" method="post">
	<input type="hidden" name="memberNo" value="<%=member.getMemberNo()%>"/>
	아이디 :
	<input type="text" name="memberId" value="<%=member.getMemberId()%>" />
	<br /> 비밀번호 :
	<input type="text" name="memberPw" value="<%=member.getMemberPw()%>" />
	<br /> 이름 :
	<input type="text" name="memberName"
		value="<%=member.getMemberName()%>" />
	<br /> F-S :
	<input type="text" name="footSize" value="<%=member.getFootsize()%>" />
	<br />
	<input type="submit" value="정보수정"/>
	</form>
</body>
</html>
