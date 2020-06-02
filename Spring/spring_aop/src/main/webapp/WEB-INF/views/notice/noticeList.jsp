<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>

      table, div{
        margin: 0 auto;
      }

      table th:first-of-type{
        width: 50px;
      }

      table th:nth-child(2){
        width: 54px;
      }

      table th:nth-child(3){
        width: 400px;
      }

      table th:nth-child(4){
        width: 100px;
      }

      table th:nth-child(5){
        width: 100px;
      }

      tr td{
        text-align: center;
        height: 70px;
      }
      
    </style>
  </head>
  <body>
    <h2>게시판!</h2>
    <hr />
    <table border="1">
      <tr>
        <th>번호</th>
        <th>이미지</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일</th>
      </tr>
      <c:forEach items="${list }" var="n">
        <tr>
          <td>${n.noticeNo}</td>
          <td>
          	<c:if test="${not empty n.filepath }">
              <img src="/resources/upload/notice/${n.filepath}" style="width: 50px;height: 50px;">
          	</c:if>
          </td>
          <td><a href="/noticeView.do?noticeNo=${n.noticeNo}">${n.noticeTitle}</a></td>
          <td>${n.noticeWriter}</td>
          <td>${n.regDate}</td>
        </tr>
      </c:forEach>
    </table>
    <div>${pageNavi}</div>
  </body>
</html>
