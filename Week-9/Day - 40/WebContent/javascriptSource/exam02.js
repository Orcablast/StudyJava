function exam01() {
  var test1 = document.getElementById("la1");
  test1.innerHTML = "ID : ";
}

function exam02() {
  var test2 = document.getElementById("pwd");
  test2.type = "password";
}

function exam03() {
  var test3 = document.getElementById("name");
  test3.placeholder = "이름을 입력하세요";
}

function exam04() {
  var test4 = document.getElementById("addr");
  test4.size = "50";
}

function exam05() {
  var inputs = document.getElementsByTagName("input");
  // for (var i = 0; i < inputs.length; i++) {
  //   alert(inputs[i].value);
  // }
  alert(
    "ID : " +
      inputs[0].value +
      "\nPW : " +
      inputs[1].value +
      "\n이름 : " +
      inputs[2].value +
      "\n주소 : " +
      inputs[3].value
  );
}
