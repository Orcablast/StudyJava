<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <script src="http://code.jquery.com/jquery-3.3.1.js"></script>
    <title>Insert title here</title>
  </head>
  <body>
    <h2>회원가입</h2>
    <hr />
    <form action="/join.do" method="POST">
      아이디 : <input type="text" name="memberId" /><span id="chkId"></span
      ><br />
      비밀번호 : <input type="password" name="memberPw" /><br />
      이름 : <input type="text" name="memberName" /><br />
      나이 : <input type="text" name="age" /><br />
      <input type="submit" value="회원가입" />
    </form>
  </body>
  <script>
    $("input[name=memberId]").keyup(function () {
      const memberId = $(this).val();

      $.ajax({
        url: "http://192.168.10.28/checkId.do",
        type: "post",
        data: { memberId: memberId },
        success: function (data) {
          if (data == "0") {
            $("#chkId").html("사용가능한 아이디");
          } else {
            $("#chkId").html("사용 불가능한 아이디");
          }
        },
        error: function () {
          console.log("서버접속 실패");
        },
      });
    });
  </script>
</html>
