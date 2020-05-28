<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판</h1>
	<hr>
	<a href="/boardWriteFrm">글작성</a>
	<form action="/deleteBoard" method="POST">
		<table border="1">
			<tr>
				<th>삭제</th>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${list }" var="b" varStatus="i">
				<tr>
					<td><input type="checkbox" name="delNo" value="${b.boardNo}"></td>
					<td>${(reqPage-1)*10+i.count}</td>
					<td><a href="/boardView?boardNo=${b.boardNo}">${b.boardTitle}</a></td>
					<td>${b.boardWriter}</td>
					<td>${b.regDate}</td>
					<td>${b.readCount}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="선택 삭제">
	</form>
	<div class="pageNavi">${pageNavi}</div>
	<div class="searchBox">
		<form action="/boardList">
			<input type="hidden" name="reqPage" value="1"> <select
				name="type">
				<c:choose>
					<c:when test="${type=='boardTitle' }">
						<option value="boardTitle" selected>제목</option>
						<option value="boardWriter">작성자</option>
					</c:when>
					<c:when test="${type=='boardWriter' }">
						<option value="boardTitle">제목</option>
						<option value="boardWriter" selected>작성자</option>
					</c:when>
					<c:otherwise>
						<option value="boardTitle">제목</option>
						<option value="boardWriter">작성자</option>
					</c:otherwise>
				</c:choose>

			</select> <input type="text" name="keyword" value="${keyword}"> <input
				type="submit" value="검색">
		</form>
	</div>
</body>
</html>