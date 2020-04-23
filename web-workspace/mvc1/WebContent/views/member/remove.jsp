<%@page import="kh.java.member.model.service.MemberService"%>
<%@page import="kh.java.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	// 세션에서 현재 로그인 정보 획득
    	Member m = (Member)session.getAttribute("member");
    	String memberId = m.getMemberId();
    
    	// 
    	int result = new MemberService().removeMember(memberId);
    	
    	if(result > 0){
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
	<script>
		<%
			if(result>0){
		%>
			alert("회원 탈퇴 성공");
		<%
			} else {
		%>
		alert("회원 탈퇴 실패");
		
		<%} %>
		location.href="/";
	</script>

</body>
</html>