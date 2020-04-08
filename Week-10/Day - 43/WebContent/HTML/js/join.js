window.onload = function () {
  document.getElementById("form").onsubmit = "return clickSubmit();";
};

function clickSubmit() {
  var err = document.getElementById("title2");
  err.innerHTML = "아이디는 소문자, 숫자로 4~12숫자";
  return false;
  if (!chkId) {
  }
}

function chkId() {
  var userId = document.getElementById("id").value;
  var regExp = /^[a-z0-9]{4,12}$}/;

  if (regExp.test(userId)) {
    return true;
  } else {
    return false;
  }
}
