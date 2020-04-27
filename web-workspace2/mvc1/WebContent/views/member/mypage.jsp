<%@page import="kh.java.member.model.vo.Member"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<% // 2가지 방법
   // 1. 세션에서 내 정보를 바로 조회 
   // 2. 세션에서 id 또는 회원번호를 통해 DB를 조회
Member m = (Member) session.getAttribute("member"); int memberNo =
m.getMemberNo(); String memberId = m.getMemberId(); String memberPw =
m.getMemberPw(); String memberName = m.getMemberName(); int footSize =
m.getFootsize(); %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-3.3.1.js"
    ></script>
  </head>
  <body>
    <script>
      $(function () {
        $("#submit").hide();
        $("#btn").click(function () {
          $(this).hide();
          $("#submit").show();
          $("input").prop("readonly", false);
        });
      });
    </script>

    <h1>마이페이지</h1>
    <hr />

    <form action="/views/member/updateMember.jsp" method="post">
      <table border="1">
        <tr>
          <th>아이디</th>

          <td>
            <input
              type="text"
              name="memberId"
              value="<%=m.getMemberId()%>"
              readonly
            />
            <input
              type="hidden"
              name="memberNo"
              value="<%= m.getMemberNo()%>"
            />
          </td>
        </tr>
        <tr>
          <th>비밀번호</th>
          <td>
            <input
              type="text"
              name="memberPw"
              value="<%=m.getMemberPw()%>"
              readonly
            />
          </td>
        </tr>
        <tr>
          <th>회원명</th>
          <td>
            <input
              type="text"
              name="memberName"
              value="<%=m.getMemberName()%>"
              readonly
            />
          </td>
        </tr>
        <tr>
          <th>발사이즈</th>
          <td>
            <input
              type="text"
              name="footSize"
              value="<%=m.getFootsize()%>"
              readonly
            />
          </td>
        </tr>
        <tr>
          <th colspan="2">
            <button type="button" id="btn">정보수정</button>
            <input type="submit" value="수정완료" id="submit" />
          </th>
        </tr>
      </table>
    </form>
  </body>
</html>
