<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/src/css/boardWrite.css" />
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
            <a href="#">우리회사게시판</a>
          </li>
          <li><a href="/boardList.do?boardType=1&reqPage=1">자유게시판</a></li>
          <li><a href="#">익명게시판</a></li>
        </ul>
      </nav>
      <div id="content">
        <div class="container">
          <form
            action="/boardWrite.do"
            method="post"
            enctype="multipart/form-data"
          >
            <input type="hidden" name="boardNo" value="${board.boardNo}" />
            <input type="hidden" name="boardType" value="${boardType}" />
            <table class="table table-bordered boardWrite">
              <tr>
                <th>제목</th>
                <td>
                  ${board.boardTitle}
                </td>
                <th>조회수</th>
                <td>${board.readCount}</td>
              </tr>
              <tr>
                <th width="15%">작성자</th>
                <td width="35%">${board.boardWriter}</td>
                <th width="10%">첨부파일</th>
                <td width="35%">파일을 첨부할 수 없습니다.</td>
              </tr>
              <tr>
                <th>내용</th>
                <td colspan="3">
                  ${board.boardContent}
                </td>
              </tr>
              <!-- <tr>
                <th colspan="4">
                  <input
                    type="submit"
                    value="등록"
                    class="btn btn-primary form-control"
                  />
                </th>
              </tr> -->
            </table>
          </form>
        </div>
      </div>
    </section>
  </body>
</html>
