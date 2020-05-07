<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Insert title here</title>
    <style>
      li {
        margin-top: 10px;
      }
      h3 {
        margin-top: 20px;
      }
    </style>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=5uvssb7zak&submodules=geocoder"></script>
    <script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <section class="container">
      <h2>1. 다음(카카오) 주소찾기 API</h2>
      <ul>
        <li>
          <input
            type="text"
            name=""
            id="postCode"
            style="width: 200px; display: inline-block;"
            class="form-control"
            placeholder="우편번호"
            readonly
          />
          <button
            id="addrSearchBtn"
            onclick="addrSearch();"
            class="btn btn-primary"
          >
            주소 검색
          </button>
        </li>
        <li>
          <input
            type="text"
            name=""
            id="roadAddr"
            style="width: 400px; display: inline-block;"
            class="form-control"
            placeholder="도로명 주소"
          />
          <input
            type="text"
            name=""
            id="oldAddr"
            style="width: 400px; display: inline-block;"
            class="form-control"
            placeholder="지번 주소"
          />
        </li>
        <li>
          <input
            type="text"
            name=""
            id="detailAddr"
            style="width: 800px; display: inline-block;"
            class="form-control"
            placeholder="상세주소"
          />
        </li>
      </ul>
      <h2>2. 네이버지도</h2>
      <div id="map" style="width: 100%; height: 500px;"></div>
      <h3>3. 결제모듈(아임포트)</h3>
      <div id="pay">
        <h4>
          <label> <input type="checkbox" value="1000" />1000원 </label>
          <label> <input type="checkbox" value="5000" />5000원 </label>
          <label> <input type="checkbox" value="10000" />10000원 </label>
          <label> <input type="checkbox" value="50000" />50000원 </label>
        </h4>
        <h4>총 결제 금액 : <span></span>원</h4>
        <button class="btn btn-danger">결제하기</button>
        <p id="paymentResult"></p>
      </div>
      <h3>4. 영화 순위검색</h3>
      <input
        type="text"
        class="form-control"
        id="movie"
        style="width: 200px; display: inline-block;"
        placeholder="ex.20200507"
      />
      <button id="movieBtn" class="btn btn-primary">영화 순위 검색</button>
      <div id="movieResult"></div>
      <h3>5. LOL 전적검색</h3>
      <input
        type="text"
        name=""
        id="lol"
        class="form-control"
        style="width: 200px; display: inline-block;"
        placeholder="소환사명 입력"
      />
      <button class="btn btn-primary" id="lolBtn">전적검색</button>
      <p id="lolResult"></p>
    </section>
    <script>
      $("#lolBtn").click(function () {
        const id = $("#lol").val();
        $.ajax({
          url: "/lolSearch",
          type: "post",
          data: { id: id },
          success: function (data) {
            console.log(data);
            let html = "";
            html += "소환사명 : " + data[0].summonerName;
            html += "솔로랭크 : " + data[0].tier + data[0].rank;
            html += "전적<br>";
            html += "WIN : " + data[0].wins + "승<br>";
            html += "LOSE : " + data[0].losses + "패";
            $("#loloResult").html(html);
          },
          error: function () {
            console.log("실패!");
          },
        });
      });

      $("#movieBtn").click(function () {
        const targetDt = $("#movie").val();
        $.ajax({
          url: "/movie",
          type: "get",
          data: { targetDt: targetDt },
          success: function (data) {
            let html = "";
            for (let i = 0; i < data.length; i++) {
              html += "순위 : " + data[i].rank + "<br>";
              html += "영화명 : " + data[i].movieNm + "<br>";
            }
            $("#movieResult").html(html);
          },
          error: function () {
            console.log("영화 실패");
          },
        });
      });

      $(function () {
        let totalPay = 0;
        $("#pay input").change(function () {
          if ($(this).is(":checked")) {
            totalPay += Number($(this).val());
          } else {
            totalPay -= Number($(this).val());
          }

          $("#pay span").html(totalPay);
        });
        $("#pay button").click(function () {
          const price = $("#pay span").html();
          const d = new Date();
          const date =
            d.getFullYear() +
            "" +
            (d.getMonth + 1) +
            "" +
            d.getDate() +
            "" +
            d.getHours() +
            "" +
            d.getMinutes() +
            "" +
            d.getSeconds();
          IMP.init("imp56584955");
          IMP.request_pay(
            {
              merchant_uid: "상품명_" + date,
              name: "결제테스트",
              amount: price,
              buyer_email: "dbro0423@gmail.com",
              buyer_name: "도형",
              buyer_tex: "010-7117-5271",
              buyer_addr: "집",
              buyer_postcode: "01234",
            },
            function (rsp) {
              if (rsp.success) {
                const msg = "결제가 완료되었습니다.";
                const r1 = "고유 ID : " + rsp.imp_uid;
                const r2 = "상점 거래 아이디 : " + rsp.merchant_uid;
                const r3 = "결제 금액 : " + rsp.paid_amount;
                const r4 = "카드 승인번호 : " + rsp.apply_num;
                $("#paymentResult").html(
                  msg +
                    "<br>" +
                    r1 +
                    "<br>" +
                    r2 +
                    "<br>" +
                    r3 +
                    "<br>" +
                    r4 +
                    "<br>"
                );
              } else {
                $("#paymentResult").html("에러 내용 : " + rsp.error_msg);
              }
            }
          );
        });
      });

      function addrSearch() {
        new daum.Postcode({
          oncomplete: function (data) {
            $("#postCode").val(data.zonecode);
            $("#roadAddr").val(data.roadAddress);
            $("#oldAddr").val(data.jibunAddress);
          },
        }).open();
      }

      window.onload = function () {
        const map = new naver.maps.Map("map", {
          center: new naver.maps.LatLng(37.533807, 126.896772),
          zoom: 17,
          zoomControl: true,
          zoomControlOptions: {
            position: naver.maps.Position.TOP_RIGHT,
            style: naver.maps.ZoomControlStyle.SMALL,
          },
        });

        const marker = new naver.maps.Marker({
          position: new naver.maps.LatLng(37.533807, 126.896772),
          map: map,
        });

        let contentString = [
          "<div class='iw_inner'>",
          "  <h3>KH정보교육원</h3>",
          "  <p>서울시 영등포구 선유로2동 57 이레빌딩 19F</p>",
          "</div>",
        ].join("");

        let infoWindow = new naver.maps.InfoWindow();
        naver.maps.Event.addListener(marker, "click", function (e) {
          if (infoWindow.getMap()) {
            infoWindow.close();
          } else {
            infoWindow = new naver.maps.InfoWindow({
              content: contentString,
            });

            infoWindow.open(map, marker);
          }
        });

        naver.maps.Event.addListener(map, "click", function (e) {
          marker.setPosition(e.coord);

          if (infoWindow != null) {
            if (infoWindow.getMap()) {
              infoWindow.close();
            }
            naver.maps.Service.reverseGeocode(
              {
                location: new naver.maps.LatLng(e.coord.lat(), e.coord.lng()),
              },
              function (status, response) {
                if (status !== naver.maps.Service.Status.OK) {
                  return alert("못찾음");
                }

                let result = response.result;
                items = result.items;

                if (items.length == 2) {
                  address = items[1].address;
                } else {
                  address = items[2].address;
                }

                contentString = [
                  "<div class='iw_inner'>",
                  " <p>" + address + "</p>",
                  "</div>",
                ].join("");
              }
            );
          }
        });
      };
    </script>
  </body>
</html>
