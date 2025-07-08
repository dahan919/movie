<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="top_menu">
  <div class="menu_btn">
    <a href="#">공지사항</a>
    <a href="#">영화</a>
    <a href="#"><img src="./img/로고 흰색.png" alt="" /></a>
    <a href="#">드라마</a>
    <a href="#">웹툰</a>
  </div>
  <ul>
    <li>
      <%
        String nickName = (String)session.getAttribute("nickName");
        if(nickName == null) nickName = "게스트";
      %>
      <%= nickName %> 님 환영합니다
    </li>
    <li>|</li>
    <li><a href="./login.html" class="logout">로그아웃</a></li>
  </ul>
</div>