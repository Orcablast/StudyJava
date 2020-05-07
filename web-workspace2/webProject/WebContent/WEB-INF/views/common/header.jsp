<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<script type="text/javascript" src="/js/jquery-3.3.1.js"></script>
<link rel="stylesheet" href="/css/bootstrap.css" />
<link rel="stylesheet" href="/css/header/style.css" />
<link rel="stylesheet" href="/css/header/responsive.css" />
<script type="text/javascript" src="/js/bootstrap.js"></script>
<header class="header_area">
  <div class="main_menu">
    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container">
        <a href="/index.jsp" class="navbar-brand logo_h">
          <img src="/img/logo.png" width="165" height="80" />
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="icon-bar"></span> <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <div
          class="collapse navbar-collapse offset"
          id="navbarSupportedContent"
        >
          <ul class="nav navbar-nav menu_nav ml-auto">
            <li class="nav-item">
              <a href="/noticeList?reqPage=1" class="nav-link">공지사항</a>
            </li>
            <li class="nav-item">
              <a href="/photoList" class="nav-link">사진 게시판</a>
            </li>
            <li class="nav-item"><a href="#" class="nav-link">Menu3</a></li>
            <li class="nav-item">
              <a href="/views/ajaxTest.jsp" class="nav-link">Ajax</a>
            </li>
            <li class="nav-item">
              <a href="/views/apiTest.jsp" class="nav-link">API</a>
            </li>
          </ul>
        </div>
        <div class="right-button">
          <ul>
            <c:if test="${empty sessionScope.member }">
              <li class="nav-item">
                <button
                  class="btn btn-danger"
                  onclick="location.href='/loginFrm'"
                >
                  로그인
                </button>
              </li>
              <li class="nav-item">
                <button
                  class="btn btn-danger"
                  onclick="location.href='/joinFrm'"
                >
                  회원가입
                </button>
              </li>
            </c:if>
            <c:if test="${not empty sessionScope.member }">
              <li class="nav-item">
                <button
                  class="btn btn-danger"
                  onclick="location.href='/mypage?memberId=${sessionScope.member.memberId}'"
                >
                  ${sessionScope.member.memberName}
                </button>
              </li>
              <li class="nav-item">
                <button
                  class="btn btn-danger"
                  onclick="location.href='/logout'"
                >
                  로그아웃
                </button>
              </li>
            </c:if>
          </ul>
        </div>
      </div>
    </nav>
  </div>
</header>
