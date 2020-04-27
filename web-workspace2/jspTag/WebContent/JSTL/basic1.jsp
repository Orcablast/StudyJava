<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL CoreTag 실습</h1>
	<c:set var="num1" value="10"></c:set>
	<c:set var="num2" value="20"></c:set>
	<c:set var="num1" value="30"></c:set>
	<c:set var="num" value="100" scope="request"></c:set>
	<c:set var="num" value="200" scope="session"></c:set>
	<p>${num1 }+${num2 } = ${num1+num2 }</p>
	<p>${requestScope.num }</p>
	<p>${sessionScope.num }</p>
	<p>${num }</p>
	<c:remove var="num1"/>
	<c:remove var="num" scope="request"/>
	<p>삭제 후 num1 : ${num1 }</p>
	<p>req-NUM : ${requestScope.num }</p>
	<p>ses-NUM : ${sessionScope.num }</p>
	<hr>
	<c:out value="100"></c:out><br>
	<c:out value="${data }" default="없음"></c:out><br>
	기본출력 : 글씨를 진하게 하려면 Bold태그를 사용하면 됨<b>1</b><br>
	<c:out value="글씨를 진하게 하려면 Bold태그를 사용하면 됨<b>1</b>" escapeXml="false"/><br>
	<c:out value="글씨를 진하게 하려면 Bold태그를 사용하면 됨<b>1</b>" escapeXml="true"/><br>
	<c:out value="글씨를 진하게 하려면 Bold태그를 사용하면 됨<b>1</b>"/><br>
	<hr>
	<h1>JSTL CoreTags</h1>
	<h3>c:if문</h3>
	<form action="/JSTL/c_if.jsp">
		숫자 입력 : <input type="text" name="num1"/><input type="submit" value="전송"/>
	</form>
	<form action="/JSTL/c_choose.jsp">
	1~3 숫자 중 하나 입력 : <input type="text" name="num2"><input type="submit" value="전송"/>	
	</form>	
	<h3><a href="/forEach">c:forEach문</a></h3>	
	<h3>c:forTokens문</h3>
	<form action="/JSTL/c_forTokens.jsp">
		취미를 적어보세요(다수일 경우 ,로 구분) : <input type="text" name="hobby"/>
		<input type="submit" value="제출"/>
	</form>
	<h3>c:url문</h3>
	<c:url var="url" value="http://search.naver.com/search.naver">
		<c:param name="query" value="전두환 사망"></c:param>
	</c:url>
	<a href="${url }">고고</a>
</body>
</html>