<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	boolean result = (Boolean) request.getAttribute("result");
	String checkId = (String) request.getAttribute("checkId");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<script>
	function setMemberId(memberId) {
		const id = opener.document.getElementsByName("memberId");
		const pw = opener.document.getElementsByName("memberPw");

		id[0].value=memberId;
		pw[0].focus();
		self.close();
	}
</script>
</head>
<body>
	<div id="checked-container">
		<%
			if (result) {
		%>
		[<span><%=checkId%></span>]는 사용이 가능합니다. <br />
		<br />
		<button type="button" onclick="setMemberId('<%=checkId%>');">닫기</button>
		<%
			} else {
		%>
		[<span><%=checkId%></span>]는 이미 사용 중입니다. <br />
		<br />
		<form action="/checkId" method="post">
			<input type="text" name="checkId" placeholder="아이디 입력" /><br /> <input
				type="submit" value="중복검사" />
		</form>
		<%
			}
		%>
	</div>
</body>
</html>
