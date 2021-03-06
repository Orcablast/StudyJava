<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>게시글 수정</h2>
    <hr>
    <form action="/updateBoard" method="POST">
        <table border="1">
            <input type="hidden" name="boardNo" value="${b.boardNo}">
            <tr>
                <th>제목</th>
                <td><input type="text" name="boardTitle" value="${b.boardTitle}"></td>                
            </tr>
            <tr>
                <th>작성자</th>
                <td>${b.boardWriter}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea name="boardContent" cols="22" rows="5">${b.boardContent}</textarea>
                </td>
            </tr>
            <tr>
                <th colspan="2">
                    <input type="submit" value="수정하기">
                </th>
            </tr>
        </table>
    </form>
</body>
</html>