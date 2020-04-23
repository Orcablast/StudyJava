<%@page import="kh.java.member.model.service.MemberService"%>
<%@page import="kh.java.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 1. 인코딩
	request.setCharacterEncoding("utf-8");

	// 2. 변수저장 
	String memberId = request.getParameter("memberId");
	String memberPw = request.getParameter("memberPw");
	Member m = new Member();
	m.setMemberId(memberId);
	m.setMemberPw(memberPw); // 3. 비지니스 로직 처리
	MemberService service = new MemberService();
	Member loginMember = service.selectOneMember(m);

	if (loginMember != null) {
		session.setAttribute("member", loginMember);
	}

	// 4. 결과 처리
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%
		if (loginMember != null) {
	%>
	<h1>로그인 성공</h1>
	<p><%=loginMember.getMemberName()%>님 환영합니다.
	</p>
	<a href="/">메인 페이지로 이동</a>
	<a href="/views/member/login.jsp">로그인 화면으로 돌아가기</a>
	<a href="/views/member/allMemberList.jsp">전체회원 조회</a>
	<a href="/views/member/mypage.jsp">마이페이지</a>
	<a href="/views/member/remove.jsp">회원탈퇴</a>

	<% } else { %>
	<h1>로그인 실패</h1>
	<a href="/views/member/login.jsp">로그인 화면으로 돌아가기</a>
	<%} %>
</body>
</html>
