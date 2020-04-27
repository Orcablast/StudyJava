<%@page import="kh.java.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member m = (Member) session.getAttribute("member");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%
		if(m==null){
	%>
	<h1>로그인</h1>
	<hr />
	<form action="/login" method="post">
		<fieldset>
			<legend>로그인</legend>
			ID : <input type="text" name="memberId" id="" /><br /> PW : <input
				type="password" name="memberPw" id="" /><br /> <input
				type="submit" value="로그인" /> <input type="reset" value="취소" />
		</fieldset>
	</form>
	<a href="/joinFrm">회원가입</a>
	
	<%} else { %>
	<h1>[<%=m.getMemberName() %>]</h1>
	<hr>
	<h3><a href="/logout">로그아웃</a></h3>
	<h3><a href="/mypage">마이페이지</a></h3>
	<h3><a href="/remove">회원탈퇴</a></h3>
	<h3><a href="/allMemberList">전체 회원 조회</a></h3>
	<h3><a href="/test">test.jsp 호출</a></h3>
	<%} %>
</body>
</html>
