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
    <button id="btn1">전체회원 조회</button>
    <table border="1">
      <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>나이</th>
      </tr>
    </table>
  </body>
  <script>
    $("#btn1").click(function () {
      $.ajax({
        url: "/selectAllMember.do",
        success: function (data) {
          html = "";
          for (let i = 0; i < data.length; i++) {
            html +=
              "<tr><td>" +
              data[i].memberId +
              "</td><td>" +
              data[i].memberName +
              "</td>";
            html += "<td>" + data[i].age + "</td></tr>";
          }
          $("table>tbody").append(html);
        },
        error: function () {
          console.log("통신실패");
        },
      });
    });
  </script>
</html>
