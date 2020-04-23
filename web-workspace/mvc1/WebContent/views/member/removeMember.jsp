<%@page import="kh.java.member.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String memberId = request.getParameter("memberId");
	int result = new MemberService().removeMember(memberId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		location.href="/views/member/allMemberList.jsp";
	</script>
</body>
</html>