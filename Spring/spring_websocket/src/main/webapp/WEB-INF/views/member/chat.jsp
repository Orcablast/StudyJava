<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="http://code.jquery.com/jquery-3.3.1.js"></script>
  </head>
  <body>
    <textarea id="msgArea" cols="30" rows="5"></textarea>
    <br />
    메세지 : <input type="text" name="" id="chatMsg" /><br />
    상대아이디 : <input type="text" name="" id="target" /><br />
    <button id="sendBtn">전송</button>
  </body>
  <script>
    let ws;
    const memberId = "${sessionScope.member.memberId}";

    connect();

    $("#sendBtn").click(function () {
      const chat = $("#chatMsg").val();
      const currMsg = $("#msgArea").val() + "\n나 : " + chat;
      $("#msgArea").val(currMsg);
      $("#chatMsg").val("");

      const sendMsg = {
        type: "chat",
        target: $("#target").val(),
        msg: chat,
      };

      ws.send(JSON.stringify(sendMsg));
    });

    function connect() {
      ws = new WebSocket("ws://192.168.10.7/chat.do");

      ws.onopen = function () {
        console.log("웹소켓 연결 생성");
        const msg = {
          type: "register",
          memberId: memberId,
        };
        ws.send(JSON.stringify(msg));
      };

      ws.onmessage = function (e) {
        const msg = e.data;
        const chat = $("#msgArea").val() + "\n상대방 : " + msg;
        $("#msgArea").val(chat);
      };

      ws.onclose = function () {
        console.log("연결 종료");
      };
    }
  </script>
</html>
