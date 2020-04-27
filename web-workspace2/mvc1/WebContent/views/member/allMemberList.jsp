<%@page import="kh.java.member.model.vo.Member"%>
<%@page import="kh.java.member.model.service.MemberService"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<Member> list = new MemberService().selectAllMember();
	Member login = (Member) session.getAttribute("member");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>발사이즈</th>
			<%
				if (login.getMemberId().equals("admin")) {
			%>
			<th>회원탈퇴</th>
			<%
				}
			%>
		</tr>
		<%
			for (Member m : list) {
				if (!m.getMemberId().equals("admin")) {
		%>
		<tr>
			<td><%=m.getMemberNo()%></td>
			<td><%=m.getMemberId()%></td>
			<td><%=m.getMemberPw()%></td>
			<td><%=m.getMemberName()%></td>
			<td><%=m.getFootsize()%></td>
			<%
				if (login.getMemberId().equals("admin")) {
			%>
			<td><a href="/views/member/removeMember.jsp?memberId=<%=m.getMemberId()%>">회원 강퇴</a></td>
			<%
				}
			%>
		</tr>
		<%
			}}
		%>
	</table>
</body>
</html>