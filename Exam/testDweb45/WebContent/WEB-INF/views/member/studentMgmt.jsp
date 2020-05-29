<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

    <title>학생 관리 페이지</title>

    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-3.3.1.js"
    ></script>

    <style>
      .studentTbl {
        width: 500px;
        border-collapse: collapse;
      }

      .studentTbl td,
      .studentTbl th {
        border: 1px solid #ccc;
        text-align: center;
      }
    </style>

    <script>
      function selectStudent() {
        $.ajax({
          url: "/selectAllStudent",

          type: "get",

          success: function (data) {
            var html = "";
            console.log(data);
            for (var i = 0; i < data.length; i++) {
              html += "<tr><td>" + data[i].grade + "</td>";

              html += "<td>" + data[i].name + "</td>";

              html += "<td>" + data[i].age + "</td>";

              html += "<td>" + data[i].address + "</td></tr>";
            }

            $(".studentTbl tr").after(html);
          },

          error: function () {
            console.log("ajax 통신실패");
          },
        });
      }
    </script>
  </head>

  <body>
    <button onclick="selectStudent();">전체 학생 조회하기</button>

    <table class="studentTbl">
      <tr>
        <th>학년</th>
        <th>이름</th>
        <th>나이</th>
        <th>주소</th>
      </tr>
    </table>
  </body>
</html>
