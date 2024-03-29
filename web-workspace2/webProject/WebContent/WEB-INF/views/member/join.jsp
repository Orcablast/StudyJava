<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Insert title here</title>
    <style>
      #memberJoin {
        width: 600px;
        margin: 0 auto;
      }
      #memberJoin > table th {
        vertical-align: middle;
      }
      #btn-box {
        text-align: center;
      }
    </style>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <section class="container">
      <form action="/join" method="post" id="memberJoin">
        <h1>회원가입</h1>
        <table class="table">
          <tr>
            <th>
              <label for="memberId">아이디</label>
            </th>
            <td>
              <input
                type="text"
                name="memberId"
                id="memberId"
                class="form-control"
              />
            </td>
          </tr>
          <tr>
            <th>
              <label for="memberPw">비밀번호</label>
            </th>
            <td>
              <input
                type="password"
                name="memberPw"
                id="memberPw"
                class="form-control"
              />
            </td>
          </tr>
          <tr>
            <th>
              <label for="pwChk">비밀번호 확인</label>
            </th>
            <td>
              <input type="password" id="pwChk" class="form-control" />
            </td>
          </tr>
          <tr>
            <th>
              <label for="memberName">이름</label>
            </th>
            <td>
              <input
                type="text"
                name="memberName"
                id="memberName"
                class="form-control"
              />
            </td>
          </tr>
          <tr>
            <th>
              <label for="age">나이</label>
            </th>
            <td>
              <input type="text" name="age" id="age" class="form-control" />
            </td>
          </tr>
          <tr>
            <th>
              <label for="email">EMAIL</label>
            </th>
            <td>
              <input type="text" name="email" id="email" class="form-control" />
            </td>
          </tr>
          <tr>
            <th>
              <label for="phone">전화번호</label>
            </th>
            <td>
              <input type="text" name="phone" id="phone" class="form-control" />
            </td>
          </tr>
          <tr>
            <th>
              <label for="address">주소</label>
            </th>
            <td>
              <input
                type="text"
                name="address"
                id="address"
                class="form-control"
              />
            </td>
          </tr>
        </table>
        <hr />
        <div id="btn-box">
          <button class="btn btn-success btn-lg" type="submit">회원가입</button>
          <button class="btn btn-success btn-lg" type="reset">초기화</button>
        </div>
      </form>
    </section>

    <script>
      $("#memberId").keyup(function () {
        const memberId = $("#memberId").val();
        $.ajax({
          url: "/checkId",
          type: "get",
          data: { memberId: memberId },
          success: function (data) {
            if (data == 1) {
              $("#memberId").css("border", "1px solid green");
            } else {
              $("#memberId").css("border", "1px solid red");
            }
          },
          error: function () {
            console.log("아이디 중복체크 실패");
          },
        });
      });
    </script>
  </body>
</html>
