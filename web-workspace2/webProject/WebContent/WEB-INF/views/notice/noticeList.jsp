<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Insert title here</title>
    <style>
      .table {
        width: 1000px;
        margin: 0 auto;
        text-align: center;
      }

      .table th:nth-child(1),
      .table th:nth-child(3),
      .table th:nth-child(4) {
        width: 100px;
      }

      #pageNavi {
        text-align: center;
        width: 1000px;
        margin: 0 auto;
      }

      #pageNavi > * {
        margin: 10px;
      }

      .selectPage {
        font-size: 18px;
        color: blue;
      }
    </style>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <section class="container">
      <h1>공지사항</h1>
      <c:if test="${sessionScope.member.memberId eq 'admin'}">
        <div style="text-align: right;">
          <a href="/noticeWriteFrm" class="btn btn-outline-primary btn-sm">
            글쓰기
          </a>
        </div>
      </c:if>
      <table class="table table-striped">
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
        </tr>
        <c:forEach items="${list }" var="n">
          <tr>
            <td>${n.noticeNo}</td>
            <td>
              <a href="/noticeView?noticeNo=${n.noticeNo}">${n.noticeTitle}</a>
            </td>
            <td>${n.noticeWriter}</td>
            <td>${n.noticeDate}</td>
          </tr>
        </c:forEach>
      </table>
      <div id="pageNavi">${pageNavi}</div>
    </section>
  </body>
</html>
