<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <section class="container">
      <h1>사진 게시판</h1>
      <div id="photo-wrapper" style="padding: 100px;"></div>
      <div id="photo-btn-container" style="text-align: center;">
        <button class="btn btn-outline-info" id="more-btn">더보기</button>
        <c:if test="${not empty sessionScope.member}">
          <button class="btn btn-outline-info" id="write-btn">글쓰기</button>
        </c:if>
      </div>
    </section>
    <script>
      $("#write-btn").click(function () {
        location.href = "/photoWriteFrm";
      });
    </script>
  </body>
</html>
