window.onload = function () {
  document.getElementById("form").onsubmit = clickSubmit;
};

function clickSubmit() {
  var err = document.getElementById("title2");
  if (!chkId()) {
    err.innerHTML = "아이디는 소문자, 숫자로 4~12숫자";
    return false;
  } else if (!chkPw()) {
    err.innerHTML = "비밀번호는 소문자, 대문자, 숫자 조합으로 8~12자리";
    return false;
  } else if (!chkPwRe()) {
    err.innerHTML = "비밀번호, 비밀번호 확인의 입력값이 다릅니다";
    return false;
  } else if (!chkName()) {
    err.innerHTML = "이름은 한글로 입력하세요";
    return false;
  } else if (!chkPhone()) {
    err.innerHTML = "전화번호를 정확히 입력하세요";
    return false;
  } else if (!chkMail()) {
    err.innerHTML = "이메일 주소를 정확히 입력하세요";
    return false;
  } else {
    err.innerHTML = "";
    return true;
  }
}

function chkId() {
  var userId = document.getElementById("id");
  var regExp = /^[a-z0-9]{4,12}$/;
  return chkExp(regExp, userId);
}

function chkPw() {
  var userPw = document.getElementById("pw");
  var regExp = /^[a-zA-Z0-9]{8,12}$/;

  return chkExp(regExp, userPw);
}

function chkExp(regExp, key) {
  if (regExp.test(key.value)) {
    key.style = "";
    return true;
  } else {
    key.style.border = "2px solid red";
    return false;
  }
}

function chkPwRe() {
  var pw = document.getElementById("pw");
  var pw_re = document.getElementById("pw_re");
  if (pw.value == pw_re.value) {
    pw.style = "";
    pw_re.style = "";
    return true;
  } else {
    pw.style.border = "2px solid red";
    pw_re.style.border = "2px solid red";
    return false;
  }
}

function chkName() {
  var userName = document.getElementById("user_name");
  var regExp = /^[가-힣]+$/;

  return chkExp(regExp, userName);
}

function chkPhone() {
  var phone2 = document.getElementById("phone2");
  var phone3 = document.getElementById("phone3");

  var regExp1 = /^[0-9]{3,4}$/;
  var regExp2 = /^[0-9]{4}$/;

  return chkExp(regExp1, phone2) && chkExp(regExp2, phone3);
}

function chkMail() {
  var mail = document.getElementById("email_addr");
  var regExp = /^[a-zA-Z0-9]{3,4}+@{1}/;

  return chkExp(regExp, mail);
}

function highlightRed(element) {
  element.style.backgroundColor = "red";
}
