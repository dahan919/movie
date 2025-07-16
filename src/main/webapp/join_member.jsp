<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>회원가입</title>
  <link rel="stylesheet" href="./resources/css/joinMember.css" />
</head>
<body>
  <div class="back_container">
    <div class="container">
      <img src="resources/img/대한민국 투명.png" alt="로고" />
      <h3>대한민국 평점 사이트에 오신걸 환영합니다.</h3>

      <form action="./join.do" method="post">
        <div class="user">
          <input type="text" name="id" placeholder="아이디" required />
          <input type="password" name="passwd" placeholder="비밀번호 (8~12자)" required />
          <input type="text" name="name" placeholder="이름" required />
          <input type="text" name="nickNm" placeholder="닉네임" required />
          <input type="text" name="ph_num" placeholder="연락처 (- 없이 입력해주세요)" required />
        </div>
        <button type="submit" class="btn">회원가입</button>
      </form>
      
      <div class="already">
        <p>이미 가입하셨나요?</p>
        <a href="./loginForm.do">로그인</a>
      </div>
    </div>
  </div>
</body>
</html>