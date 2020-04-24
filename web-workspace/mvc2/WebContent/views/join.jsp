<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.js"></script>
<title>Insert title here</title>
<script>
	function checkId() {
		const memberId = $("input[name=memberId]").val();
		const url = "/checkId"; // 중복체크를 처리할 Servlet Mapping값
		const title = "checkId"; // 새로 열리는 창과 checkIdFrm form을 연결할 값

		//status -> 새로 열리는 창의 옵션
		const status = "left=500px, top=100px, width=300px, height=200px, menubar=no, status=no, scrollbars=yes";

		const popup = window.open("", title, status);
		$("input[name=checkId]").val(memberId);
		$("#checkIdFrm").attr("action", url);
		$("#checkIdFrm").attr("method", "post");
		$("#checkIdFrm").attr("target", title);
		$("#checkIdFrm").submit();

		if (memberId == "") {
			alert("아이디를 입력하세요");
			return false;
		}
	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form id="checkIdFrm">
		<input type="hidden" name="checkId"/>
    </form>
    <form action="/join" method="POST">
      <fieldset>
        <legend>회원가입</legend>
        아이디 : <input type="text" name="memberId" id="" />
        <button type="button" onclick="checkId();">
          중복체크</button
        ><br />
        비밀번호 : <input type="password" name="memberPw" id="" /><br />
        이름 : <input type="text" name="memberName" id="" /><br />
        발사이즈 : <input type="text" name="footSize" id="" /><br />
        <input type="submit" value="가입" /> <input type="reset" value="취소" />
      </fieldset>
    </form>
  </body>
</html>
