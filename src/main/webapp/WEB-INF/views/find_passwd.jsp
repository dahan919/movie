<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>비밀번호 변경</title>
  <link rel="stylesheet" href="./resources/css/joinMember.css" />
</head>
<body>
  <div class="back_container">
    <div class="container">
      <img src="resources/img/대한민국 투명.png" alt="로고" />
      <h3>비밀번호 찾기/변경하기</h3>

      <form action="findPasswdChk.jsp" method="post" onsubmit="return checkPassword()">
        <div class="user">
          <input type="text" name="ID" placeholder="아이디" required />
          <input type="text" name="ph_num" placeholder="연락처 (- 없이 입력해주세요)" required />
          <input type="password" name="passwd" id="passWd1" placeholder="새로운 비밀번호 (8~12자)" required />
          <input type="password" name="passwd" id="passWd2" placeholder="새로운 비밀번호 확인 (8~12자)" required />
        </div>
        <button type="submit" class="btn">비밀번호 변경하기</button>
      </form>

    </div>
  </div>

  <script>
    function checkPassword() {
      const pw1 = document.getElementById("passWd1").value;
      const pw2 = document.getElementById("passWd2").value;

      if (pw1 == pw2) {
        return true;
      } else {
        alert("비밀번호가 맞지 않습니다.");
        return false;
      }
    }
  </script>
</body>
</html>