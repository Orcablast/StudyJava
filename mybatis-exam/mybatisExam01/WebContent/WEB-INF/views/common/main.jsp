<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="/src/css/main.css" />
    <title>Insert title here</title>
  </head>
  <body>
    <header>
      <span>A_CLASS</span>
      <div>
        <a href="#">
          <img
            src="/src/imgs/com-logo/${sessionScope.member.companyName}.png"
            alt=""
            srcset=""
          />
          MYPAGE
        </a>
        <a href="#">LOGOUT</a>
      </div>
    </header>
    <section>
      <nav>
        <span>WELCOME</span>
        <ul>
          <li><a href="#">NOTICE</a></li>
          <li><a href="#">우리회사게시판</a></li>
          <li><a href="#">자유게시판</a></li>
          <li><a href="#">익명게시판</a></li>
        </ul>
      </nav>
      <div class="main">
        <div>
          <div class="img_wrapper">
            <img
              src="/src/imgs/com-logo/${sessionScope.member.companyName}.png"
            />
          </div>
          <div class="content_wrapper">
            <table>
              <tr>
                <th>소속</th>
                <td>${sessionScope.member.companyName}</td>
              </tr>
              <tr>
                <th>아이디</th>
                <td>${sessionScope.member.memberId}</td>
              </tr>
              <tr>
                <th>이름</th>
                <td>${sessionScope.member.memberName}</td>
              </tr>
              <tr>
                <th>전화번호</th>
                <td>${sessionScope.member.phone}</td>
              </tr>
              <tr>
                <th>회원등급</th>
                <c:if test="${sessionScope.member.memberLevel == 1 }">
                <td>일반회원</td>
                </c:if>
                <c:if test="${sessionScope.member.memberLevel == 2 }">
                <td>중간 관리자</td>
                </c:if>
                <c:if test="${sessionScope.member.memberLevel == 3 }">
                <td>관리자</td>
                </c:if>
              </tr>
            </table>
          </div>
        </div>
        <button>비밀번호 변경하기</button>
      </div>
    </section>
  </body>
</html>
