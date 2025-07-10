<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>모든 코멘트 - 위플래쉬</title> 
    <link rel="stylesheet" href="./menu.css" />
    <link rel="stylesheet" href="./footer.css" />
    <style>
        /* 기본 초기화 */
        * {
            margin: 0; padding: 0; 
            box-sizing: border-box;
        }
        body {
            font-family: 'Malgun Gothic', sans-serif;
            background-color: #000000;
            color: #333; /* 기본 글자색 설정 */
        }
        a { text-decoration: none; color: inherit; }
        ul { list-style: none; }

        /* 상단 메뉴 (detail_page2.html에서 복사) */
        .header-hero {
           
            top: 0;
            left: 0;
            width: 100%;
            height: 250px; /* 적당한 높이 설정 */
            overflow: hidden;
            display: flex;
            justify-content: center;
            align-items: center;
            z-index: 0; /* 다른 콘텐츠보다 아래에 오도록 설정 */
        }
        .header-hero::before {
            content: "";
            position: absolute;
            top: 0; left: 0; width: 100%; height: 100%;
            background-image: url('./KakaoTalk_20250708_160525065.jpg'); /* 두 번째 이미지 사용 */
            background-size: cover;
            background-position: center;
            filter: blur(10px) brightness(0.7); /* 블러 강도 및 어둡기 조절 */
            transform: scale(1.05); /* 약간 확대하여 블러 효과 부드럽게 */
            z-index: -1; /* 가상 요소가 콘텐츠 아래에 오도록 */
        }
        .header-content {
            position: relative; /* 콘텐츠가 블러 배경 위에 오도록 */
            z-index: 1; /* 블러 배경보다 위에 오도록 */
            color: white;
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 15px;
        }
        .main-logo {
            width: 150px; /* 로고 크기 */
            height: auto;
        }
        .nav-menu {
            display: flex;
            gap: 30px;
            font-size: 1.2em;
            font-weight: bold;
        }
        .nav-menu a {
            padding: 5px 10px;
            transition: color 0.3s;
        }
        .nav-menu a:hover {
            color: #ffcc00;
        }
        .login-info {
            position: absolute;
            top: 20px;
            right: 20px;
            color: white;
            font-size: 0.9em;
        }


        /* 포스터 배경 */
        .movie-hero {
            position: relative; padding: 60px 20px;
            display: flex; justify-content: center; align-items: center;
            overflow: hidden;
            background-color: #333; /* 배경색으로 블러된 포스터가 보일 수 있도록 어둡게 */
        }
        .movie-hero::before {
            content: ""; position: absolute; top: 0; left: 0; width: 100%; height: 100%;
            background-image: url('./img/whiplash_poster.jpg');
            background-size: cover; background-position: center;
            filter: blur(15px) brightness(0.6); transform: scale(1.1);
            z-index: -1;
        }
        
        /* 상세 정보 */
        .movie-details-container {
            display: flex; gap: 40px; align-items: flex-start;
            max-width: 900px; width: 100%; color: white;
            padding: 20px; /* 내부 여백 추가 */
            background-color: rgba(0, 0, 0, 0.4); /* 내용이 더 잘 보이도록 반투명 배경 추가 */
            border-radius: 10px;
        }
        .poster-image img {
            width: 250px; border-radius: 10px;
            align-items: center;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.5);
        }
        .movie-info { flex: 1; }
        .movie-info h1 {
            font-size: 40px; margin-bottom: 15px;
        }
        .movie-info .rating {
            font-size: 18px; margin-bottom: 20px; font-weight: bold;
        }
        .movie-info .story {
            font-size: 16px; line-height: 1.6;
        }

        /* 코멘트 섹션 */
        .comments-section {
            max-width: 900px; margin: 40px auto; padding: 20px;
        }
        .comments-section h2 { 
            font-size: 24px;
            color: #ffffff;
            margin-bottom: 20px;
            text-align: center; /* 가운데 정렬 */
        }

        /* comment2.html에서는 코멘트 작성 폼이 일반적으로 필요 없습니다. */
        /* .comment-form {} */ 

        .comment-list {
            display: flex; flex-wrap: wrap; gap: 20px; padding: 0;
        }
        .comment-list li { 
            background-color: #E6E2D1; 
            border-radius: 8px; 
            padding: 20px;
            flex: 1 1 calc((100% - 40px) / 3); 
            min-width: 250px; 
            box-shadow: 0 2px 4px rgba(0,0,0,0.1); 
            border-bottom: none; 
        } 
        .comment-author {
            font-weight: bold; margin-bottom: 10px;
            color: rgb(38, 73, 97); font-size: 14px;
        }
        .comment-content {
            font-size: 16px; color: #333;
            white-space: normal; 
            overflow: visible; 
            text-overflow: clip; 
        }
        .comment-author .rating-stars { 
            color: #FFC700;
            margin-left: 5px;
        }

        /* 돌아가기 버튼 */
        .back-button-container {
            text-align: center; margin: 30px 0 50px;
        }
        .back-btn {
            display: inline-block; padding: 12px 40px;
            font-size: 16px; font-weight: bold;
            color: white; background-color: rgb(38, 73, 97);
            border: none; 
            border-radius: 8px; transition: background-color 0.2s;
            cursor: pointer; 
        }
        .back-btn:hover {
            background-color: rgb(28, 53, 71);
        }
        
    </style>
</head>

<body>
    <div class="top_menu">
        <div class="menu_btn">
          <a href="#">홈</a>
          <a href="#">영화</a>
        <!--   <a href="#"><img src="./img/로고 흰색.png" alt="" /></a> -->
          <a href="#">드라마</a>
          <a href="#">웹툰</a>
        </div>
        <ul>
          <li>${nickname} 님 환영합니다</li>
          <li>|</li>
       <!--    <li><a href="./login.html" class="logout">로그아웃</a></li> -->
        </ul>
      </div>
    <main> 
        <section class="movie-hero">
            <div class="movie-details-container">
                <div class="poster-image">
                    <img src="./img/whiplash.jpg" alt="위플래쉬 포스터">
                </div>
                <div class="movie-info">
                    <h1>위플래쉬</h1>
                    <div class="rating">개봉일: 2015. 03. 12 평점: 4.0</div>
                    <p class="story">
                        뉴욕 최고의 음악 학교에 다니지만 특별히 주목받지 못하던 드러머 앤드류. 최고의 드러머를 꿈꾸며 연습에만 매달리던 어느 날, 최고의 실력자이자 최악의 폭군으로 불리는 플레처 교수에게 발탁된다. 
                        그의 무자비한 방식은 학생의 한계를 시험하는 동시에, 앤드류를 성공과 광기의 갈림길로 이끈다...
                        <br><br>
                        "세상에서 제일 해로운 말이 뭔지 알아? '그 정도면 잘했어'야" 미친놈 vs 미친놈, 광기와 광기가 폭발!
                    </p>
                </div>
            </div>
        </section>

        <section class="comments-section">
            <h2>모든 코멘트</h2> 
            <ul class="comment-list"></ul>
        </section>

        <section class="back-button-container">
            <button class="back-btn">돌아가기</button> 
        </section> 
        
    </main>

    <script>
        // 로컬 스토리지에 저장될 키
        const LOCAL_STORAGE_KEY = 'whiplash_comments';

        // 로컬 스토리지에서 코멘트 데이터를 불러오는 함수
        function loadCommentsFromLocalStorage() {
            const storedData = localStorage.getItem(LOCAL_STORAGE_KEY);
            if (storedData) {
                return JSON.parse(storedData);
            }
            return []; // 데이터가 없으면 빈 배열 반환
        }

        let commentData = loadCommentsFromLocalStorage(); // 페이지 로드 시 데이터 불러오기

        const commentList = document.querySelector('.comment-list');
        const backBtn = document.querySelector('.back-btn'); 

        function getStars(rating) {
            const fullStars = Math.floor(rating);
            return '★'.repeat(fullStars) + '☆'.repeat(5 - fullStars);
        }

        // createCommentElement 함수 수정: 백틱 대신 문자열 연결 사용
        function createCommentElement(comment) {
            const li = document.createElement('li');

            // JavaScript 함수 호출 결과를 변수에 저장
            const starsHtml = getStars(comment.rating);
            const formattedRating = comment.rating.toFixed(1);

            // 문자열 연결을 사용하여 innerHTML 구성
            let htmlContent = '';
            htmlContent += '<div class="comment-author">';
            htmlContent += "'" + comment.author + "'님의 한줄평 ";
            htmlContent += '<span class="rating-stars">' + starsHtml + '</span> ';
            htmlContent += '(평점 : ' + formattedRating + ')';
            htmlContent += '</div>';
            htmlContent += '<div class="comment-content">' + comment.content + '</div>';

            li.innerHTML = htmlContent;
            return li;
        }

        function displayAllComments(comments) {
            commentList.innerHTML = ''; // 기존 목록 초기화
            // 최신 코멘트부터 보여주기 위해 timestamp를 기준으로 정렬
            const sortedComments = [...comments].sort((a, b) => b.timestamp - a.timestamp);
            
            sortedComments.forEach(comment => {
                commentList.appendChild(createCommentElement(comment));
            });
        }

        // 초기 로드 시 불러온 모든 코멘트 표시
        displayAllComments(commentData);

        // '돌아가기' 버튼 클릭 이벤트
     if (backBtn) {
            backBtn.addEventListener('click', () => {
                window.location.href = 'detailPage.jsp'; 
            });
        } 
    </script>
    <script src="./top_menu.js"></script>
    <script src="./gddd/footer.js"></script>
</body>
</html>