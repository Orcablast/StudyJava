<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<script
  src="https://kit.fontawesome.com/8bd2671777.js"
  crossorigin="anonymous"
></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<!-- <script
  src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
  integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
  crossorigin="anonymous"
></script> -->
<script
  src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
  integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
  crossorigin="anonymous"
></script>
<script src="/src/js/bootstrap/bootstrap.min.js"></script>
<header>
  <span>A_CLASS</span>
  <div>
    <button
      type="button"
      id="msgBtn"
      data-toggle="modal"
      data-target="#msgModal"
    >
      <i class="far fa-envelope"></i><span id="msgCount">0</span>
    </button>
    <a href="#">
      <img
        src="/src/imgs/com-logo/${sessionScope.memberCompany.companyName}.png"
      />
      MYPAGE
    </a>
    <a href="#">LOGOUT</a>
  </div>
</header>

<!-- Modal -->
<div
  class="modal fade"
  id="msgModal"
  tabindex="-1"
  role="dialog"
  aria-labelledby="exampleModalLabel"
  aria-hidden="true"
>
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">받은 쪽지함</h5>
        <button
          type="button"
          class="close"
          data-dismiss="modal"
          aria-label="Close"
        >
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <table id="msgTbl" class="table">
          <thead class="thead-dark">
            <tr>
              <th scope="col">보낸 사람</th>
              <th scope="col">내용</th>
              <th scope="col">보낸 시간</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>아무개</td>
              <td>내요오오오오오오옹</td>
              <td>어느날</td>
            </tr>
            <tr>
              <td>아무개</td>
              <td>내요오오오오오오옹</td>
              <td>어느날</td>
            </tr>
          </tbody>
        </table>
        <form id="msgForm">
          <div class="form-group">
            <input
              type="hidden"
              id="msgSender"
              value="${sessionScope.member.memberId}"
            />
            <label for="recipient-name" class="col-form-label"
              >받는 사람 :</label
            >
            <input type="text" class="form-control" id="recipient-name" />
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">쪽지 내용 :</label>
            <textarea class="form-control" id="message-text"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">
          닫기
        </button>
        <button type="button" id="writeBtn" class="btn btn-primary">
          쪽지 보내기
        </button>
      </div>
    </div>
  </div>
</div>
<script>
  let ws;

  wsConnect();

  function sendMsg() {
    const msgReceiver = $("#recipient-name").val();
    const msgSender = $("#msgSender").val();
    const msgContent = $("#message-text").val();

    const msg = {
      type: "msg",
      msgSender: msgSender,
      msgReceiver: msgReceiver,
      msgContent: msgContent,
    };

    ws.send(JSON.stringify(msg));

    $("#recipient-name").val("");
    $("#msgSender").val("");
    $("#message-text").val("");
  }

  function wsConnect() {
    ws = new WebSocket("ws://192.168.10.7/msg.do");
    const memberId = "${sessionScope.member.memberId}";

    ws.onopen = function () {
      const msg = {
        type: "register",
        memberId: memberId,
      };

      ws.send(JSON.stringify(msg));
    };

    ws.onmessage = function (e) {
      console.log(e.data);
      $("#msgCount").html(e.data);
    };

    ws.onclose = function () {
      const msg = {
        type: "exit",
        memberId: memberId,
      };

      ws.send(JSON.stringify(msg));
    };
  }

  $("#msgForm").hide();

  $("#writeBtn").click(showForm);

  $("#msgModal").on("hidden.bs.modal", function () {
    showTbl();

    if ($(".modal-footer").children().length == 4) {
      $(".modal-footer").children().eq(0).remove();
      $(".modal-footer").children().eq(1).remove();
    } else if ($(".modal-footer").children().length == 3) {
      $(".modal-footer").children().eq(1).remove();
    }
  });

  function showTbl() {
    $("#msgForm").hide();
    $("#msgTbl").show();
    const btn = document.createElement("button");
    btn.innerHTML = "쪽지 보내기";
    btn.classList.add("btn");
    btn.classList.add("btn-primary");
    $(this).remove();
    $(".modal-footer").append(btn);
    btn.addEventListener("click", showForm);
  }

  function showForm() {
    $("#msgTbl").hide();
    $("#msgForm").show();
    const btn = document.createElement("button");
    btn.innerHTML = "목록으로";
    btn.classList.add("btn");
    btn.classList.add("btn-primary");
    $(this).remove();
    $(".modal-footer").append(btn);
    btn.addEventListener("click", showTbl);

    const sendBtn = document.createElement("button");
    sendBtn.innerHTML = "전송";
    sendBtn.classList.add("btn");
    sendBtn.classList.add("btn-primary");
    $(".modal-footer").prepend(sendBtn);
    sendBtn.addEventListener("click", sendMsg);
  }
</script>
