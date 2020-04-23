<%@page import="kh.java.member.model.vo.Member"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <% Member m =
(Member)session.getAttribute("member"); %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <% if(m == null) {%>
    <h1>로그인</h1>
    <hr />
    <form action="/views/member/loginMember.jsp" method="POST">
      아이디 : <input type="text" name="memberId" /> <br />
      비밀번호 : <input type="password" name="memberPw" /><br />
      <input type="submit" value="로그인" />
      <input type="reset" value="취소" />
    </form>
    <a href="/views/member/joinFrm.html">회원가입</a>
    <% } else { %>
    <h3><%= m.getMemberName() %>님 반갑습니다</h3>
    <hr />
    <a href="/views/member/logout.jsp">로그아웃</a>
    <%} %>
  </body>
</html>
