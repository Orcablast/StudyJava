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
	<c:if test="${empty sessionScope.member }">
		<form action="/login">
			아이디 : <input type="text" name="memberId" /><br> 비밀번호 : <input
				type="password" name="memberPw" /><br> <input type="submit"
				value="로그인"> <input type="reset" value="취소">
				<a href="/joinFrm">회원가입</a>
		</form>
	</c:if>
	<c:if test="${not empty sessionScope.member }">
	<h2>[${sessionScope.member.memberName }]님 반갑습니다</h2>
	<hr>
	<a href="/allMember">전체회원 조회</a>
	<a href="/allMemberPage?reqPage=1">전체 회원 조회(페이징)</a>
	<a href="/mypage">내정보 보기</a>
	<a href="/delete">회원탈퇴</a>
	<a href="/logout">로그아웃</a>
	<h2>Mybatis 동줙쿼리</h2>
	<a href="/boardList?reeqPage=1">게시판 ㄱㄱ</a><br>
	<a href="/views/dynamicQuery_if.html">1. 동적쿼리 if</a><br>	
	<a href="/views/dynamicQuery_choose.html">2. 동적쿼리 choose</a><br>
	<a href="/views/dynamicQuery_trim.html">3. 동적쿼리 trim</a><br>
	<a href="/views/dynamicQuery_foreach.html">4. 동적쿼리 forEach</a><br>
	</c:if>
</body>
</html>