<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <c:if test="${empty sessionScope.member}">
      <form action="/login.do" method="POST">
        아이디 :
        <input type="text" name="memberId" placeholder="아이디" /><br />
        비밀번호 :
        <input type="password" name="memberPw" placeholder="비밀번호" /><br />
        <input type="submit" value="로그인" />
      </form>
      <a href="/joinFrm.do">회원가입</a>
    </c:if>
    <c:if test="${not empty sessionScope.member}">
      <a href="allMember.do">회원관리</a>
      <a href="/mypage.do">마이페이지</a>
      <a href="/logout.do">로그아웃</a>
      <a href="/delete.do">회원 탈퇴</a>
      <hr>
      <a href="/noticeWriteFrm.do">게시글 작성</a>      
      <a href="/noticeList.do?reqPage=1">게시글 목록</a>      
    </c:if>
  </body>
</html>
