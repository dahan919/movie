<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>아이디 찾기</title>
  <link rel="stylesheet" href="./resources/css/joinMember.css" />
</head>
<body>
  <div class="back_container">
    <div class="container">
      <img src="resources/img/대한민국 투명.png" alt="로고" />
      <h3>아이디찾기</h3>

      <form action="findIdChk.jsp" method="post">
        <div class="user">
          <input type="text" name="name" placeholder="이름(성함)" required />
          <input type="text" name="ph_num" placeholder="연락처 (- 없이 입력해주세요)" required />
        </div>
        <button type="submit" class="btn">아이디찾기</button>
      </form>
      <div class="footer">
          <a href="./loginForm.do">로그인으로 돌아가기</a>
          <p>|</p>
          <a href="./findPasswdForm.do">비밀번호 찾기</a>
          <p>|</p>
          <a href="./join.do">회원가입</a>
        </div>
    </div>
  </div>
</body>
</html>