<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>로그인</title>
    <link rel="stylesheet" href="./resources/css/loginform.css" />
  </head>
  <body>
    <div class="back_login">
      <div class="login_container">
        <h1>로그인</h1>
        <p>평가의 나라 대한민국에서 모든 리뷰를 남겨주세요</p>
        <form action="./login.do" method="post">
          <div class="user_menu">
            <input type="text" name="id" class="id" placeholder="아이디" />
            <input
              type="password"
              name="passwd"
              class="passwd"
              placeholder="비밀번호 (8~12자)"
            />
          </div>
          <button type="submit" class="login">로그인</button>
        </form>
        <div class="footer">
          <a href="./findIdForm.do">아이디 찾기</a>
          <p>|</p>
          <a href="./findPasswdForm.do">비밀번호 찾기</a>
          <p>|</p>
          <a href="./join.do">회원가입</a>
          <p>|</p>
          <a href="./adminLoginForm.do">관리자</a>
        </div>
      </div>
    </div>
  </body>
</html>
