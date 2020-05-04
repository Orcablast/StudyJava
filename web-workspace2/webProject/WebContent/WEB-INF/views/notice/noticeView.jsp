<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<style>
.table-wrapper, .comment-write, .comment-wrapper {
	width: 1000px;
	margin: 0 auto;
}

.commentList {
	width: 100%;
	clear: both;
	border: 1px solid #ccc;
	border-radius: 5px;
	overflow: hidden;
}

.commentList>li {
	float: left;
	color: black;
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
				<td><c:if test="${not empty n.fileName }">
						<img src="/img/file.png" width="16px">
						<a href="javascript:fileDownload('${n.fileName}','${n.filePath}')">${n.fileName}</a>
					</c:if></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${n.contentBr}</td>
			</tr>
			<tr>
				<th colspan="2"><c:if
						test="${not empty sessionScope.member && sessionScope.member.memberId == 'admin' }">
						<a href="/updateNoticeFrm?noticeNo=${n.noticeNo }"
							class="btn btn-outline-primary btn-sm">수정하기</a>
						<a href="javascript:void(0)"
							onclick="deleteNotice('${n.noticeNo}')"
							class="btn btn-outline-primary btn-sm">삭제하기</a>
					</c:if> <a href="/noticeList?reqPage=1"
					class="btn btn-outline-primary btn-sm">목록으로</a></th>
			</tr>
		</table>
		<c:if test="${not empty sessionScope.member }">
			<div class="comment-write">
				<form action="/noticeCommentInsert" method="post">
					<input type="hidden" name="noticeCommentWriter"
						value="${sessionScope.member.memberId}"> <input
						type="hidden" name="noticeRef" value="${n.noticeNo}"> <input
						type="hidden" name="noticeCommentLevel" value="1"> <input
						type="hidden" name="noticeCommentRef" value="0">
					<table class="table">
						<tr>
							<td width="85%"><input type="text" class="form-control"
								name="noticeCommentContent"></td>
							<td width="15%">
								<button type="submit" class="btn btn-primary">작성</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</c:if>
		<div class="comment-wrapper">
			<c:forEach items="${list }" var="nc">
				<c:if test="${nc.noticeCommentLevel eq 1}">
				<ul class="commentList">
					<li style="width: 10%;text-align: center;" ><span>${nc.noticeCommentWriter}</span></li>
					<li style="width: 60%;">
						<span>${nc.noticeCommentContent}</span>
						<input type="text" name="noticeCommentContent" class="form-control" value="${nc.noticeCommentContent}" style="display: none;">
					</li>
					<li style="width: 10%;text-align: center;"><span>${nc.noticeCommentDate}</span></li>
					<li style="width: 20%;text-align: center;"><c:if
							test="${not empty sessionScope.member }">
							<a href="javascript:void(0)" onclick="insertComment(this,'${nc.noticeCommentNo}','${n.noticeNo}','${sessionScope.member.memberId}');">댓글달기</a>
							<c:if
								test="${sessionScope.member.memberId == nc.noticeCommentWriter}">
					<a href="javascript:void(0)" onclick="modifyComment(this,'${nc.noticeCommentNo}','${nc.noticeRef}');">수정</a>
								<a href="javascript:void(0)" onclick="deleteComment('${nc.noticeCommentNo}','${nc.noticeRef}');">삭제</a>
							</c:if>
						</c:if></li>
				</ul>
			</c:if>
			<c:forEach items="${list}" var="ncc">
				<c:if test="${ncc.noticeCommentLevel eq 2 && nc.noticeCommentNo eq ncc.noticeCommentRef}">
					<ul class="commentList">
						<li style="width: 5%;text-align: center;"><span>└─  </span></li>
						<li style="width: 10%;text-align: center;"><span>${ncc.noticeCommentWriter}</span></li>
						<li style="width: 55%;">
							<span>${ncc.noticeCommentContent}</span>
							<input type="text" name="noticeCommentContent" class="form-control" value="${ncc.noticeCommentContent}" style="display: none;">
						</li>
						<li style="width: 10%;text-align: center;"><span>${ncc.noticeCommentDate}</span></li>
						<li style="width: 20%;text-align: center;">
						<c:if test="${not empty sessionScope.member && sessionScope.member.memberId eq ncc.noticeCommentWriter}">
							<a></a>
							<a href="javascript:void(0)" onclick="modifyComment(this,'${nc.noticeCommentNo}','${nc.noticeRef}');">수정</a>
							<a href="javascript:void(0)" onclick="deleteComment('${nc.noticeCommentNo}','${nc.noticeRef}');">삭제</a>							
						</c:if>

						</li>
					</ul>
				</c:if>
			</c:forEach>
			</c:forEach>
		</div>
	</div>
	</section>
	<script>
		function fileDownload(fileName, filePath) {
			const newFileName = encodeURIComponent(fileName);
			const newFilePath = encodeURIComponent(filePath);
			location.href = "/noticeFileDownload?fileName=" + newFileName
					+ "&filePath=" + newFilePath;
		}

		function deleteNotice(noticeNo) {
			if (confirm("실화임?")) {
				location.href = "/deleteNotice?noticeNo=" + noticeNo;
			}
		}

		function insertComment(obj,commentNo,noticeNo,memberId){
			$(obj).parent().hide();
			const $form = $("<form action = '/noticeCommentInsert' method='post'></form>");
			const $ul = $("<ul class='commentList'></ul>");

			$form.append($("<input type='hidden' name='noticeCommentWriter' value='"+memberId+"'>"));
			$form.append($("<input type='hidden' name='noticeRef' value='"+noticeNo+"'>"));
			$form.append($("<input type='hidden' name='noticeCommentLevel' value='2'>"));
			$form.append($("<input type='hidden' name='noticeCommentRef' value='"+commentNo+"'>"));

			const $li1 = $("<li style='width:5%'>└─</li>");
			const $li2 = $("<li style='width:75%'></li>");
			$li2.append($("<input type='text' name='noticeCommentContent' class='form-control'>"));
			const $li3 = $("<li style='width:20%'></li>");
			$li3.append($("<button type='submit' class='btn btn-link btn-sm'>등록</button>"));
			$li3.append($("<button type='button' class='btn btn-link btn-sm' onclick='insertCancel(this);'>취소</button>"))			

			$ul.append($li1).append($li2).append($li3);

			$form.append($ul);

			$(obj).parent().parent().after($form);
		}

		function insertCancel(obj){
			$(obj).parents('form').prev().children().last().show();
			$(obj).parents('form').remove();
		}

		function deleteComment(noticeCommentNo,noticeRef){
			location.href="/noticeCommentDelete?noticeCommentNo="+noticeCommentNo+"&noticeRef="+noticeRef;
		}

		function modifyComment(obj,noticeCommentNo,noticeRef){
			$(obj).prev().hide();
			$(obj).html("수정완료");
			$(obj).attr('onclick','modifyComplete(this,"'+noticeCommentNo+'","'+noticeRef+'")');
			$(obj).next().html("취소");
			$(obj).next().attr('onclick','modifyCancel(this,"'+noticeCommentNo+'","'+noticeRef+'")');
			$(obj).parent().parent().find('input').show();
			$(obj).parent().parent().find('input').prev().hide();
		}

		function modifyCancel(obj,noticeCommentNo, noticeRef){
			$(obj).prev().prev().show();
			$(obj).prev().html("수정");
			$(obj).prev().attr('onclick','modifyComment(this,"'+noticeCommentNo+'","'+noticeRef+'")');
			$(obj).html("삭제");
			$(obj).attr('onclick','deleteComment("'+noticeCommentNo+'","'+noticeRef+'")');
			$(obj).parent().parent().find('input').hide();
			$(obj).parent().parent().find('input').prev().show();
		}

		function modifyComplete(obj,noticeCommentNo,noticeRef){
			const $form=$("<form action='/noticeCommentUpdate' method='post'></form>");
			$form.append($("<input type='text name='noticeCommentNo' value='"+noticeCommentNo+"'>"));
			$form.append($("<input type='text name='noticeRef' value='"+noticeRef+"'>"));
			$form.append($(obj).parent().parent().find("input"));
			$('body').append($form);
			$form.submit();
		}
	</script>
</body>
</html>
