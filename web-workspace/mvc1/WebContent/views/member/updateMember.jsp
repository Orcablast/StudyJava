<%@page import="kh.java.member.model.service.MemberService"%>
<%@page import="kh.java.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 1. 인코딩
	request.setCharacterEncoding("utf-8");

	// 2. 수취값 변수 저장
	Member m = new Member();
	m.setMemberNo(Integer.parseInt(request.getParameter("memberNo")));
	m.setMemberId(request.getParameter("memberId"));
	m.setMemberPw(request.getParameter("memberPw"));
	m.setMemberName(request.getParameter("memberName"));
	m.setFootsize(Integer.parseInt(request.getParameter("footSize")));
	
	// 3. 비지니스 로직 처리
	int result = new MemberService().updateMember(m);
	
	if(result>0){
		session.setAttribute("member", m);
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
<%
	if(result>0) {
%>
	alert("수정 성공");
	
<% } else { %>
	alert("수정 실패");
<%} %>

	location.href = "/views/member/mypage.jsp";

</script>
</head>
<body>

</body>
</html>