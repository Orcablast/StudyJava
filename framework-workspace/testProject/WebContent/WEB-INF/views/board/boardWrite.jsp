<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>게시글 작성</h2>
    <hr>
    <form action="/boardWrite" method="POST">
        제목 : <input type="text" name="boardTitle" id=""><br>
        작성자 : <input type="text" name="boardWriter" id=""><br>
        내용 : <textarea name="boardContent" id="" cols="20" rows="5"></textarea><br>
        <input type="submit" value="등록">
    </form>
</body>
</html>