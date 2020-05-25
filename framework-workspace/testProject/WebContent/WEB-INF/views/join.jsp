<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>회원가입</h1>
    <hr>
    <form action="/join" method="POST">
        아이디 : <input type="text" name="memberId" id="memberId"><br>
        비밀번호 : <input type="password" name="memberPw" id=""><br>
        이름 : <input type="text" name="memberName" id="memberName"><br>
        나이 : <input type="text" name="age" id=""><br>
        <input type="submit" value="가입">
        <input type="reset" value="취소">
    </form>
</body>
</html>