<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/src/css/join.css">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<body>
    <section>
        <span>회원가입</span>
        <form action="/insertMember" method="POST">
            <div>
                <label for="select_company">소속 선택</label>
                <select name="companyCode" id="select_company">
                    <option value="0">소속을 선택해주세요</option>
                    <c:forEach items="${list }" var="c">
                    	<option value="${c.companyCode }">${c.companyName }</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="input_id">아이디</label>
                <span class="msg">EMAIL 형식이 맞지 않습니다.</span>
                <input type="text" name="memberId" id="input_id" placeholder="email 형식 입력">
            </div>
            <div>
                <label for="input_pw">비밀번호</label>
                <span class="msg">영문/숫자/특수문자 조합 8~15자리</span>
                <input type="password" name="memberPw" id="input_pw">
            </div>
            <div>
                <label for="repeat_pw">비밀번호 확인</label>
                <span class="msg">비밀번호가 일치하지 않습니다.</span>
                <input type="password" name="memberPw_re" id="repeat_pw">
            </div>
            <div>
                <label for="input_name">이름</label>
                <span class="msg">본명이 아닌 경우 반려될 수 있습니다.</span>
                <input type="text" name="memberName" id="input_name" placeholder="본명을 입력해주세요">
            </div>
            <div>
                <label for="input_phone">전화번호</label>
                <span class="msg">전화번호 형식이 틀립니다. <br> ex) 000-0000-0000</span>
                <input type="text" name="phone" id="input_phone" placeholder="010-0000-0000">
            </div>
            <button type="submit">가입 하기</button>
        </form>
        <a href="/index.jsp">메인으로 돌아가기</a>
    </section>
</body>
<script>
    $(".msg").hide();

    $("form").submit(function(){

        if(chkId() && chkName() && chkPw() && chkRe() && chkCompany() && chkPhone()){
            $(this).attr("action","/insertMember");
            return true;
        } else {
            alert("입력란을 정확히 입력해주세요.")
            return false;        
        }
    });

    document.getElementById("input_id").addEventListener("focusout", chkId);
    document.getElementById("input_pw").addEventListener("focusout", chkPw);
    document.getElementById("repeat_pw").addEventListener("focusout", chkRe);
    document.getElementById("input_name").addEventListener("focusout",chkName);
    document.getElementById("input_phone").addEventListener("focusout",chkPhone);

    function chkPhone(){
        const input = $("#input_phone");
        const regExp = /^\d{2,3}-\d{3,4}-\d{4}$/;

        return testExp(regExp,input);
    }

    function chkName(){
        const input = $("#input_name");
        const val = $("#input_name").val();

        if(val != ""){
            input.prev().html("본명이 아닌 경우 반려될 수 있습니다.");            
            input.prev().css("color","blue");
            input.prev().show();
            return true;
        } else {
            input.prev().html("이름을 입력해주세요.");
            input.prev().css("color","red");
            input.prev().show();
            return false;
        }
    }

    function chkRe(){
        const pw = $("#input_pw").val();
        const re = $("#repeat_pw").val();
        const input = $("#repeat_pw");

        if(pw == re && re != ""){
            input.prev().hide();
            return true;
        } else {
            input.prev().show();
            return false;
        }
    }

    function chkPw(){
        const input = $("#input_pw");
        const regExp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

        return testExp(regExp,input);
    }

    function chkCompany(){
        const select = $("#select_company");
        const val = select.val();

        if(val==0){
            alert("소속을 선택하세요")
            return false;
        } else{
            return true;
        }
    }

    function chkId(){
        const input = $("#input_id");
        const regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

        return testExp(regExp, input);
    }

    function testExp(regExp, input){
        const val = input.val();

        if(regExp.test(val) && val != ""){
            input.prev().hide();
            return true;
        } else {
            input.prev().show();
            return false;
        }
    }

</script>
</html>