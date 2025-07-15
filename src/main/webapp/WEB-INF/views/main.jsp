<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>메인 페이지</title>
  <link rel="stylesheet" href="./resources/css/header.css" />
  <link rel="stylesheet" href="./resources/css/footer.css" />
  <style>
    html, body {
      width: 100%;
      height: 100%;
      background-color: black;
    }
    .search {
      width: 90%;
      height: 50px;
      border: 1px solid white;
      background-color: white;
      border-radius: 10px;
      padding-left: 10px;
      display: flex;
      flex-flow: row nowrap;
      margin: 0 auto;
      margin-bottom: 60px;
    }
    .search > input {
      width: 95%;
      border: none;
      padding-left: 10px;
      font-size: 1.2em;
    }
    .search > input:focus {
      outline: none;
    }
    .search img {
      width: 50px;
      height: 50px;
    }
    h3 {
      color: white;
      margin-bottom: 20px;
    }
    .main_container hr {
      margin-bottom: 30px;
    }
    .main_container h3 {
      padding-left: 30px;
    }
    .pick_movie {
      width: 100%;
      height: 300px;
      background-color: rgba(0,0,0,0.7);
      display: flex;
      flex-flow: row nowrap;
      justify-content: center;
      gap: 80px;
      border-bottom: 2px solid #ffc60a;
      border-top: 2px solid #ffc60a;
      margin-bottom: 100px;
      overflow: hidden;
    }
    .pick_movie img {
      max-height: 100%;
      width: auto;
    }
  </style>
<script>
	window.onload = () => {
	  document.getElementById("searchBtn").onclick = function() {
	   doSearch();
	  };
	
	  document.getElementById("searchInput").addEventListener("keydown", function(e) {
	    if (e.key === "Enter") {
	      doSearch();
	    }
	  });
	
	  function doSearch() {
	    const keyword = document.getElementById("searchInput").value.trim();
	    if (keyword === "") {
	      alert("검색어를 입력해주세요.");
	      return;
	    }
	  }
	}
</script>
</head>
<body>
  <div class="wrapper">
    <div class="container">
      <div class="main_container">
        <jsp:include page="./template/header.jsp"></jsp:include>
        <hr color="#ffc60a" />
        <div class="search">
          <input type="text" placeholder="검색어를 입력하세요" />
          <img src="./resources/img/돋보기.png" id="searchBtn" style="cursor:pointer;" />
        </div>

        <h3>운영진의 PICK MOVIE!</h3>
        <div class="pick_movie">
          <a href=""><img src="./resources/img_movie/괴물.webp" alt="괴물" /></a>
          <a href=""><img src="./resources/img_movie/위플레쉬.webp" alt="위플레쉬" /></a>
          <a href=""><img src="./resources/img_movie/바람과함께사라지다.webp" alt="바람과함께사라지다" /></a>
          <a href=""><img src="./resources/img_movie/명량.webp" alt="명량" /></a>
          <a href=""><img src="./resources/img_movie/파묘.webp" alt="파묘" /></a>
        </div>

        <h3>이달의 MOVIE</h3>
        <jsp:include page="./template/carouser_movie.jsp"></jsp:include>

        <h3>이달의 DRAMA</h3>
        <jsp:include page="./template/carouser_drama.jsp"></jsp:include>
      </div>
    </div>
  </div>
  <jsp:include page="./template/footer.jsp"></jsp:include>
</body>
</html>