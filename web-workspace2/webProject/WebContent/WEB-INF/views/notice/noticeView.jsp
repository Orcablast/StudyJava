<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<style>
.table-wrapper {
	width: 1000px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
	<section class="container">
	<div class="table-wrapper">
		<h1>공지</h1>
		<table class="table table-bordered">
			<tr>
				<th>제목</th>
				<td>${n.noticeTitle}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${n.noticeWriter}</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:if test="${not empty n.fileName }">
                        <img src="/img/file.png" width="16px">
                        <a href="javascript:fileDownload('${n.fileName}','${n.filePath}')">${n.fileName}</a>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${n.contentBr}</td>
            </tr>
            <tr>
                <th colspan="2">
                    <c:if test="${not empty sessionScope.member && sessionScope.member.memberId == 'admin' }">
                        <a href="/updateNoticeFrm?noticeNo=${n.noticeNo }" class="btn btn-outline-primary btn-sm">수정하기</a>
                        <a href="javascript:void(0)" onclick="deleteNotice('${n.noticeNo}')" class="btn btn-outline-primary btn-sm">삭제하기</a>                        
                    </c:if>                    
                    <a href="/noticeList?reqPage=1" class="btn btn-outline-primary btn-sm">목록으로</a>
                </th>
            </tr>
		</table>
	</div>
    </section>
    <script>
        function fileDownload(fileName,filePath){
            const newFileName = encodeURIComponent(fileName);
            const newFilePath = encodeURIComponent(filePath);
            location.href="/noticeFileDownload?fileName="+newFileName+"&filePath="+newFilePath;
        }

        function deleteNotice(noticeNo){
            if(confirm("실화임?")){
                location.href="/deleteNotice?noticeNo="+noticeNo;
            }
        }
    </script>
</body>
</html>
