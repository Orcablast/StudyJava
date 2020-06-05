<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/src/css/board.css" />
    <title>Insert title here</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <section>
      <nav>
        <span>WELCOME</span>
        <ul>
          <li><a href="#">NOTICE</a></li>
          <li>
            <a href="/boardList.do?boardType=1&reqPage=1">우리회사게시판</a>
          </li>
          <li><a href="#">자유게시판</a></li>
          <li><a href="#">익명게시판</a></li>
        </ul>
      </nav>
      <div id="content">
        <div class="container">
          <div class="boardTop">
            <form action="/board/boardList.do">
              <input type="hidden" name="boardType" value="${boardType }" />
              <input type="hidden" name="reqPage" value="${reqPage }" />
              <select name="type" class="form-control">
                <option value="board_title">제목</option>
                <option value="board_no">글번호</option>
              </select>
              <input type="text" name="keyword" class="form-control" value="" />
              <input type="submit" class="btn btn-primary" value="검색" />
              <button
                type="button"
                style="float: right;"
                class="btn btn-primary"
                onclick="return sendWrite('${boardType}');"
              >
                글쓰기
              </button>
            </form>
          </div>
          <table class="table table-bordered boardList">
            <tr>
              <th width="7%" style="min-width: 57px;">번호</th>
              <th width="60%">제목</th>
              <th width="13%" style="min-width: 57px;">작성자</th>
              <th width="10%" style="min-width: 57px;">작성일</th>
              <th width="10%" style="min-width: 57px;">조회수</th>
            </tr>
            <c:forEach items="${list }" var="b" varStatus="i">
              <tr>
                <td>${(reqPage-1)*10+ i.count }</td>
                <td>
                  <a href="/boardView.do?boardNo=${b.boardNo }"
                    >${b.boardTitle }
                  </a>
                </td>
                <td>${b.boardWriter }</td>
                <td>${b.regDate }</td>
                <td>${b.readCount }</td>
              </tr>
            </c:forEach>
          </table>
          <div class="pageNavi">${pageNavi }</div>
        </div>
      </div>
    </section>
  </body>
</html>
