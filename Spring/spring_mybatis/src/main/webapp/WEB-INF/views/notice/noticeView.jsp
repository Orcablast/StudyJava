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
    <h2>게시글 보기</h2>
    <hr />
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
        <td>${n.noticeTitle}</td>
      </tr>
      <tr>
        <th>첨부파일</th>
        <td>
          <img src="/resources/upload/notice/${n.filepath}" alt="" srcset="" />
        </td>
      </tr>
      <tr>
        <th>내용</th>
        <td>${n.noticeContent}</td>
      </tr>
    </table>
    <a href="/noticeList.do?reqPage=1">목록으로</a>
    <div>
      <button id="modBtn" value="${n.noticeNo}">수정</button>
      <button id="delBtn" value="${n.noticeNo}">삭제</button>
    </div>
  </body>
  <script>
    document.getElementById("modBtn").addEventListener("click", function () {
      location.href = "/modifyNoticeFrm.do?noticeNo=" + this.value;
    });

    document.getElementById("delBtn").addEventListener("click", function () {
      if (confirm("이 게시글을 정말 삭제하시겠습니까?")) {
        location.href = "/deleteNotice.do?noticeNo=" + this.value;
      }
    });
  </script>
</html>
