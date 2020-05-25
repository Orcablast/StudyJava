<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>마이페이지</h1>
    <hr>
    <form action="/updateMember" method="POST">
        아이디 : <input type="text" name="memberId" value="${sessionScope.member.memberId}" readonly><br>
        비밀번호 : <input type="password" name="memberPw" value="${sessionScope.member.memberPw}"><br>
        이름 : <input type="text" name="memberName" value="${sessionScope.member.memberName}"><br>
        나이 : <input type="text" value="${sessionScope.member.age}" readonly><br>
        가입일 : <input type="text" value="${sessionScope.member.enrollDate}" readonly><br>
        <input type="submit" value="제출">
        <input type="reset" value="취소">
    </form>
</body>
</html>