<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/src/css/index.css">
</head>
<body>
    <section>
        <span>A_CLASS</span>
        <form action="/login" method="POST">
        <div>
            <label for="input_id">아이디</label>
            <input type="text" name="memberId" id="input_id">
        </div>
        <div>
            <label for="input_pw">비밀번호</label>
            <input type="password" name="memberPw" id="input_pw">
        </div>
        <button type="submit">로그인</button>
        </form>
        <div>
            <a href="/joinFrm">회원가입</a>
            <a href="/">아이디/비밀번호 찾기</a>
        </div>
    </section>
</body>
</html>