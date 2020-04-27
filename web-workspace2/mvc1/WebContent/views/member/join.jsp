<%@page import="kh.java.member.model.service.MemberService"%>
<%@page import="kh.java.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// 1. 인코딩
    	request.setCharacterEncoding("utf-8");
    	// 2. 값 저장
    	Member m = new Member();
    	m.setMemberId(request.getParameter("memberId"));
    	m.setMemberPw(request.getParameter("memberPw"));
    	m.setMemberName(request.getParameter("memberName"));
    	m.setFootsize(Integer.parseInt(request.getParameter("footSize")));  	
    	
    	// 3. 비즈니스 로직 처리
    	int result = new MemberService().insertMember(m);    	
    	
    	// 4. 결과 처리
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	<% 
		if(result>0){		
	%>
	
		alert("회원가입 성공");
		location.href="/views/member/login.jsp";
	
	<%
		} else	{
	%>
		alert("회원가입 실패");
		location.href="/";
	
	<% } %>
</script>
</head>
<body>

</body>
</html>