<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
.top_menu ul {
  background-color: black;
  width: 280px;
  list-style-type: none;
  display: flex;
  flex-flow: row nowrap;
  align-items: center;
  font-size: 14px;
  font-weight: bold;
  gap: 10px;
  color: white;
  padding-left: calc(100% - 280px);
}
.logout {
  text-decoration: none;
  color: white;
  /* color: black */
}
.menu_btn {
  background-color: black;
  width: 100%;
  height: 150px;
  display: flex;
  flex-flow: row nowrap;
  align-items: center;
  justify-content: center;
  gap: 80px;
}
.menu_btn a {
  color: white;
  /* color: black; */
  text-decoration: none;
  font-weight: bold;
  font-size: 1.2em;
  width: 150px;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
  z-index: 1;
}
.menu_btn a::after {
  content: "";
  position: absolute;
  left: 0;
  bottom: 2px;
  width: 100%;
  height: 6px;
  background-color: #ffc60a;
  border-radius: 50px;
  transform: scaleX(0);
  transform-origin: left;
  transition: transform 0.5s ease-out;
  z-index: 2;
}
.menu_btn a:hover::after {
  transform: scaleX(1);
}
.menu_btn a > img {
  width: 150px;
  height: 150px;
}
.menu_btn a > img:hover {
  width: 160px;
  height: 160px;
  transition: all 0.3s;
}

</style>
<div class="top_menu">
  <div class="menu_btn">
     <a href="./userNoticeForm.do">공지사항</a>
    <a href="#">영화</a>
    <a href="#"><img src="${pageContext.request.contextPath}/resources/img/로고흰색.png" alt="logo" /></a>
    <a href="#">드라마</a>
    <a href="#">웹툰</a>
  </div>
  <ul>
    <li>
      <%
        String nickNm = (String)session.getAttribute("nickNm");
        if(nickNm == null) nickNm = "방문자";
      %>
      <%= nickNm %> 님 환영합니다
    </li>
    <li>|</li>
    <li><a href="./loginForm.do" class="logout">로그아웃</a></li>
  </ul>
</div>