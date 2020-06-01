<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <script src="http://code.jquery.com/jquery-3.3.1.js"></script>
    <title>Insert title here</title>
  </head>
  <body>
    <h2>게시글 보기</h2>
    <hr />
    <form action="/modifyNotice.do" method="post" enctype="multipart/form-data">
      <table border="1">
        <tr>
          <th>작성일</th>
          <td>${n.regDate}</td>
        </tr>
        <tr>
          <th>작성자</th>
          <td>${n.noticeWriter}</td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="noticeTitle" value="${n.noticeTitle}" />
          </td>
        </tr>
        <tr>
          <th>첨부파일</th>
          <td class="img_container">
            <img src="/resources/upload/notice/${n.filepath}" />
            <div class="btn_container">
              <button type="button" id="imgMod">수정</button>
              <button type="button" id="imgDel">삭제</button>
            </div>
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>${n.noticeContent}</td>
        </tr>
      </table>
      <input type="hidden" name="noticeNo" value="${n.noticeNo}" />
      <input type="hidden" name="filepath" value="${n.filepath}" />
      <div>
        <button type="submit">수정 완료</button>
        <button type="button" id="cancelBtn">취소</button>
      </div>
    </form>
  </body>
  <script>
    let html = "";

    $("#imgMod").click(function () {
      const container = $(".img_container");
      html = container.html();
      container.children().remove();

      const input = document.createElement("input");
      input.type = "file";
      input.name = "file";

      const btn = document.createElement("button");
      btn.type = "button";
      btn.id = "cancel";
      btn.html("복원");

      container.append(input);
      container.append(btn);

      $("#cancel").click(function () {
        const container = $(".img_container");
        container.children().remove();
        container.append(html);
      });
    });
  </script>
</html>
