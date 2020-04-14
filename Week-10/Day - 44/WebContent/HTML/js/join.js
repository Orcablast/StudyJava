window.onload = function () {
  document.getElementById("form").onsubmit = clickSubmit;
};

function clickSubmit() {
  bool = true;

  if (!chkId("아이디는 소문자, 숫자로 4~12숫자")) {
    bool = false;
  }
  if (!chkPw("비밀번호는 소문자, 대문자, 숫자 조합으로 8~12자리")) {
    bool = false;
  } else if (!chkPwRe("비밀번호, 비밀번호 확인의 입력값이 다릅니다")) {
    bool = false;
  }
  if (!chkName("이름은 한글로 입력하세요")) {
    bool = false;
  }
  if (!chkPhone("전화번호를 정확히 입력하세요")) {
    bool = false;
  }
  if (!chkMail("이메일 주소를 정확히 입력하세요")) {
    bool = false;
  }

  return bool;
}

function chkId(msg) {
  var userId = document.getElementById("id");
  var regExp = /^[a-z0-9]{4,12}$/;
  return chkExp(regExp, userId, msg);
}

function chkPw(msg) {
  var userPw = document.getElementById("pw");
  var regExp = /^[a-zA-Z0-9]{8,12}$/;
  return chkExp(regExp, userPw, msg);
}

function chkExp(regExp, key, msg) {
  var err = key.parentElement.parentElement.getElementsByClassName(
    "input_desc"
  )[0];
  err.innerHTML = "";
  if (regExp.test(key.value)) {
    key.style = "";
    return true;
  } else {
    err.appendChild(document.createTextNode(msg));
    key.style.border = "2px solid red";
    return false;
  }
}

function chkPwRe(msg) {
  var pw = document.getElementById("pw");
  var pw_re = document.getElementById("pw_re");

  var err1 = pw.parentElement.parentElement.getElementsByClassName(
    "input_desc"
  )[0];

  var err2 = pw_re.parentElement.parentElement.getElementsByClassName(
    "input_desc"
  )[0];

  err1.innerHTML = "";
  err2.innerHTML = "";

  if (pw.value == pw_re.value) {
    pw.style = "";
    pw_re.style = "";
    return true;
  } else {
    err1.appendChild(document.createTextNode(msg));
    err2.appendChild(document.createTextNode(msg));
    pw.style.border = "2px solid red";
    pw_re.style.border = "2px solid red";
    return false;
  }
}

function chkName(msg) {
  var userName = document.getElementById("user_name");
  var regExp = /^[가-힣]+$/;

  return chkExp(regExp, userName, msg);
}

function chkPhone(msg) {
  var phone2 = document.getElementById("phone2");
  var phone3 = document.getElementById("phone3");

  var regExp1 = /^[0-9]{3,4}$/;
  var regExp2 = /^[0-9]{4}$/;

  return chkExp(regExp1, phone2, msg) || chkExp(regExp2, phone3, msg);
}
function chkMail(msg) {
  var mail = document.getElementById("email_addr");
  var regExp = /^[a-zA-Z0-9]{4,12}@{1}[a-zA-Z0-9,.]+$/;

  return chkExp(regExp, mail, msg);
}
