<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>아이디 찾기</title>
  <link rel="stylesheet" href="./css/joinMember.css" />
</head>
<body>
  <div class="back_container">
    <div class="container">
      <img src="./img/대한민국 투명.png" alt="로고" />
      <h3>아이디찾기</h3>

      <form action="findIdChk.jsp" method="post">
        <div class="user">
          <input type="text" name="userName" placeholder="이름(성함)" required />
          <input type="text" name="phone" placeholder="연락처 (- 없이 입력해주세요)" required />
        </div>
        <button type="submit" class="btn">아이디찾기</button>
      </form>
    </div>
  </div>
</body>
</html>