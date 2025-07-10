<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>상세 정보 페이지 - 위플래쉬</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/menu.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/footer.css" />
    <style>
        /* 기본 초기화 */
        * {
            margin: 0; padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: 'Malgun Gothic', sans-serif;
            background-color: #000000; /* 전체 배경을 어둡게 */
            color: #ffffff; /* 기본 글자색을 흰색으로 */
        }
        a { text-decoration: none; color: inherit; }
        ul { list-style: none; }

        /* 새로운 상단 블러 배경 및 강조 이미지 영역 */
        .top-background-container {
            position: relative; /* 자식 요소의 absolute 위치 기준 */
            width: 100%;
            height: 350px; /* 상단 영역의 높이 설정, 필요에 따라 조절 */
            overflow: hidden; /* 블러된 배경 이미지가 넘치지 않도록 */
            z-index: 0; /* 헤더 메뉴보다 아래에 위치 */
        }

        .top-background-image {
            width: 100%;
            height: 100%;
            object-fit: cover; /* 이미지가 컨테이너를 꽉 채우도록 */
            filter: blur(15px) brightness(0.5); /* 블러 강도 및 어둡기 조절 */
            transform: scale(1.05); /* 약간 확대하여 블러 효과 부드럽게 */
        }

        /* 상단 고정 메뉴 (메뉴 내용은 여기) */
        .header-hero {
            position: fixed; /* 화면에 고정 */
            top: 0;
            left: 0;
            width: 100%;
            height: 80px; /* 메뉴의 높이 */
            background-color: rgba(0, 0, 0, 0.8); /* 메뉴 배경색 (투명도 포함) */
            display: flex;
            justify-content: space-between; /* 로고/메뉴와 로그인 정보 분리 */
            align-items: center;
            padding: 0 30px; /* 좌우 패딩 */
            z-index: 10; /* 가장 위에 위치 */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.5); /* 메뉴 그림자 */
        }
        .header-hero::before { /* 기존에 있던 가상 요소 (블러 배경) 제거 */
            content: none;
        }

        .header-content {
            display: flex;
            align-items: center;
            gap: 40px; /* 로고와 메뉴 사이 간격 */
        }
        .main-logo {
            width: 120px; /* 로고 크기 */
            height: auto;
        }
        .nav-menu {
            display: flex;
            gap: 25px; /* 메뉴 아이템 간격 */
            font-size: 1.1em;
            font-weight: bold;
        }
        .nav-menu a {
            padding: 5px 10px;
            color: white;
            transition: color 0.3s;
        }
        .nav-menu a:hover {
            color: #ffcc00;
        }
        .login-info {
            color: white;
            font-size: 0.9em;
        }

        /* 영화 상세 정보 (하단 포스터 배경) */
        .movie-hero {
            position: relative; /* 자식 요소의 absolute 위치 기준 */
            padding: 60px 20px; /* 상단 패딩은 제거하거나 줄임, 새로운 이미지 영역으로 대체 */
            display: flex; justify-content: center; align-items: center;
            overflow: hidden;
            background-color: #222; /* 배경색으로 블러된 포스터가 보일 수 있도록 어둡게 */
            padding-top: 50px; /* 상세 정보 섹션 상단 여백 */
        }
        .movie-hero::before {
            content: ""; position: absolute; top: 0; left: 0; width: 100%; height: 100%;
            /* 이미지 경로 수정 */
            background-image: url('<%=request.getContextPath()%>/img/whiplash_poster.jpg'); /* 영화 포스터 배경 이미지 */
            background-size: cover; background-position: center;
            filter: blur(15px) brightness(0.6); transform: scale(1.1);
            z-index: -1;
        }

        /* 상세 정보 컨테이너 */
        .movie-details-container {
            display: flex; gap: 40px; align-items: flex-start;
            max-width: 900px; width: 100%; color: white;
            padding: 30px; /* 내부 여백 추가 */
            background-color: rgba(0, 0, 0, 0.6); /* 내용이 더 잘 보이도록 반투명 배경 추가 */
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.7);
        }
        .poster-image img {
            width: 250px; border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.5);
        }
        .movie-info { flex: 1; }
        .movie-info h1 {
            font-size: 40px; margin-bottom: 15px;
            color: #ffcc00; /* 제목 색상 강조 */
        }
        .movie-info .rating {
            font-size: 18px; margin-bottom: 20px; font-weight: bold;
            color: #eee;
        }
        .movie-info .story {
            font-size: 16px; line-height: 1.6;
            color: #ccc;
        }

        /* 코멘트 섹션 */
        .comments-section {
            max-width: 900px; margin: 40px auto; padding: 20px;
            background-color: #111; /* 코멘트 섹션 배경색 */
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.5);
        }
        .comments-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
            border-bottom: 2px solid #555; /* 구분선 색상 변경 */
            padding-bottom: 10px;
        }
        .comments-header h2 {
            font-size: 24px;
            color: #ffcc00; /* 제목 색상 강조 */
            margin: 0;
        }

        .more-comments-btn {
            background-color: #264961;
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 5px;
            font-size: 14px;
            cursor: pointer;
            transition: background-color 0.2s;
        }
        .more-comments-btn:hover {
            background-color: #1c3647;
        }
        .more-comments-btn:disabled {
            background-color: #aaa;
            cursor: not-allowed;
        }

        /* 코멘트 폼 스타일 */
        .comment-form {
            background-color: #333; padding: 20px; border-radius: 8px;
            display: flex; align-items: center; gap: 15px; margin-bottom: 10px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            margin-top: 20px; /* 코멘트 리스트와 구분 */
        }
        .comment-form .form-rating {
            display: flex; align-items: center; gap: 5px;
            font-weight: bold; color: #eee;
        }
        .comment-form .stars {
            color: #FFC700; font-size: 20px;
            cursor: pointer; /* 별점 클릭 가능하게 */
        }
        .comment-form .stars span { /* 개별 별 */
            display: inline-block;
        }
        .comment-form input[type="text"] {
            flex-grow: 1; border: none; padding: 12px 15px;
            border-radius: 20px; font-size: 16px;
            background-color: #555;
            color: white;
        }
        .comment-form input[type="text"]::placeholder {
            color: #aaa;
        }
        .comment-form .save-btn {
            background-color: #264961; color: white; border: none;
            padding: 12px 25px; border-radius: 20px;
            font-size: 16px; font-weight: bold; cursor: pointer;
            transition: background-color 0.2s;
        }
        .comment-form .save-btn:hover {
            background-color: #1c3647;
        }

        .comment-list {
            display: flex; flex-wrap: wrap; gap: 20px; padding: 0;
            margin-bottom: 20px; /* 폼과 리스트 사이 간격 */
        }
        .comment-list li {
            background-color: #333; /* 코멘트 배경색 변경 */
            border-radius: 8px;
            padding: 20px;
            flex: 1 1 calc((100% - 40px) / 3);
            min-width: 250px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.3);
            border-bottom: none;
            color: #eee;
        }

        .comment-author {
            font-weight: bold; margin-bottom: 10px;
            color: #ffcc00; /* 작성자 이름 색상 강조 */
            font-size: 14px;
        }
        .comment-content {
            font-size: 16px; color: #ccc;
            white-space: nowrap; /* 한 줄로 표시 */
            overflow: hidden; /* 넘치는 부분 숨김 */
            text-overflow: ellipsis; /* ...으로 표시 */
        }
        .comment-content:hover { /* 툴팁 효과 */
            overflow: visible;
            white-space: normal;
            word-break: break-all;
        }
        .comment-author .rating-stars {
            color: #FFC700;
            margin-left: 5px;
        }

        /* 이달의 영화/드라마/웹툰 섹션 스타일 */
        .content-section {
            max-width: 900px;
            margin: 40px auto;
            padding: 20px;
            background-color: #111;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.5);
        }

        .content-section h2 {
            font-size: 24px;
            color: #ffcc00;
            margin-bottom: 20px;
            border-bottom: 2px solid #555;
            padding-bottom: 10px;
        }

        .content-list {
            display: flex;
            flex-wrap: wrap; /* 여러 줄로 감싸기 */
            gap: 20px; /* 아이템 간격 */
            justify-content: flex-start; /* 시작점에서 정렬 */
            padding: 0;
        }

        .content-item {
            flex: 0 0 calc(25% - 15px); /* 한 줄에 4개씩, 간격 고려 */
            max-width: calc(25% - 15px); /* 한 줄에 4개씩, 간격 고려 */
            background-color: #333; /* 배경색 추가 */
            border-radius: 8px;
            overflow: hidden; /* 이미지 밖으로 나가지 않도록 */
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
            text-align: center;
            transition: transform 0.2s ease-in-out;
        }

        .content-item:hover {
            transform: translateY(-5px); /* 호버 시 약간 위로 */
        }

        .content-item img {
            width: 190px;  /* 고정된 가로 크기 */
            height: 268px; /* 이미지 비율에 맞춰 조정한 세로 크기 */
            object-fit: cover; /* 비율을 유지하면서 공간을 채우고, 넘치는 부분은 잘라냄 */
            display: block; /* 이미지 하단 공백 제거 */
            border-radius: 8px 8px 0 0; /* 상단만 둥글게 */
        }

        /* 반응형 디자인 */
        @media (max-width: 768px) {
            .content-item {
                flex: 0 0 calc(50% - 10px); /* 태블릿에서 2개씩 */
                max-width: calc(50% - 10px);
            }
            .content-item img {
                width: 100%; /* 반응형에서는 부모 너비에 맞춤 */
                height: 250px; /* 태블릿에서 높이 조절 (화면 크기에 따라 조절 필요) */
            }
        }

        @media (max-width: 480px) {
            .content-item {
                flex: 0 0 100%; /* 모바일에서 1개씩 */
                max-width: 100%;
            }
            .content-item img {
                width: 100%; /* 반응형에서는 부모 너비에 맞춤 */
                height: 300px; /* 모바일에서 높이 조절 (화면 크기에 따라 조절 필요) */
            }
        }
    </style>
</head>

<body>
    <div class="top-background-container">
        <img src="<%=request.getContextPath()%>/KakaoTalk_20250708_160525065.jpg" alt="블러 처리된 배경 이미지" class="top-background-image">
    </div>
    
    <header class="header-hero">
        <div class="header-content">
            <img src="<%=request.getContextPath()%>/img/main_logo.png" alt="사이트 로고" class="main-logo">
            <nav class="nav-menu">
                <a href="#">홈</a>
                <a href="#">영화</a>
                <a href="#">드라마</a>
                <a href="#">웹툰</a>
            </nav>
        </div>
        <div class="login-info">로그아웃</div>
    </header>

    <main style="padding-top: 0;"> 
        <section class="movie-hero">
            <div class="movie-details-container">
                <div class="poster-image">
                    <img src="<%=request.getContextPath()%>/img/whiplash.jpg" alt="위플래쉬 포스터">
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
            <div class="comments-header">
                <h2>대한민국 코멘트</h2>
                <button class="more-comments-btn">코멘트 더 보기</button> 
            </div>
            <ul class="comment-list"></ul>
            <div class="comment-form-container"></div>
        </section>

        <section class="content-section">
            <h2>이달의 영화</h2>
            <ul class="content-list">
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/m.webp" alt="바람과 함께 사라지다">
                    </a>
                </li>
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/mo.webp" alt="피우">
                    </a>
                </li>
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/p.webp" alt="명량">
                    </a>
                </li>
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/whiplash.jpg" alt="파묘">
                    </a>
                </li>
            </ul>
        </section>

        <section class="content-section">
            <h2>이달의 드라마</h2>
            <ul class="content-list">
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/gone_with_the_wind.jpg" alt="바람과 함께 사라지다">
                    </a>
                </li>
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/piu.jpg" alt="피우">
                    </a>
                </li>
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/myungrang.jpg" alt="명량">
                    </a>
                </li>
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/pamo.jpg" alt="파묘">
                    </a>
                </li>
            </ul>
        </section>

        <section class="content-section">
            <h2>이달의 웹툰</h2>
            <ul class="content-list">
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/webtoon1.jpg" alt="녹두전">
                    </a>
                </li>
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/webtoon2.jpg" alt="자취생을 위한 웹툰">
                    </a>
                </li>
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/webtoon3.jpg" alt="감각의 절제">
                    </a>
                </li>
                <li class="content-item">
                    <a href="#">
                        <img src="<%=request.getContextPath()%>/img/webtoon4.jpg" alt="파묘 웹툰">
                    </a>
                </li>
            </ul>
        </section>

    </main>

    <script>
        // 로컬 스토리지에 저장될 키 (여러 영화가 있다면 영화 ID 등으로 구분)
        const LOCAL_STORAGE_KEY = 'whiplash_comments';

        // 초기 코멘트 데이터 (로컬 스토리지에 데이터가 없을 경우 사용될 기본값)
        const initialCommentData = [
            { author: '대한', rating: 5.0, content: '간절함이 담긴 영화', timestamp: Date.now() - 5000 },
            { author: '민국', rating: 3.5, content: '그 정도는 아닌듯?', timestamp: Date.now() - 4000 },
            { author: '크라임', rating: 3.5, content: '아 어렵다', timestamp: Date.now() - 3000 },
            { author: '철수', rating: 4.0, content: '정말 몰입감 넘치는 영화였습니다. 드럼 연주가 최고였어요!', timestamp: Date.now() - 2000 },
            { author: '영희', rating: 2.5, content: '너무 폭력적인 장면이 많아서 불편했어요. 음악 영화인데 꼭 이렇게까지 해야 했나 싶네요.', timestamp: Date.now() - 1000 },
        ];

        // 로컬 스토리지에서 코멘트 데이터를 불러오거나, 없으면 초기 데이터 사용
        let commentData = loadCommentsFromLocalStorage();

        // 로컬 스토리지에서 코멘트를 불러오는 함수
        function loadCommentsFromLocalStorage() {
            const storedData = localStorage.getItem(LOCAL_STORAGE_KEY);
            if (storedData) {
                // JSON 문자열을 객체로 파싱
                return JSON.parse(storedData);
            }
            // 데이터가 없으면 초기 데이터 저장 후 반환
            saveCommentsToLocalStorage(initialCommentData);
            return initialCommentData;
        }

        // 코멘트 데이터를 로컬 스토리지에 저장하는 함수
        function saveCommentsToLocalStorage(comments) {
            // 객체를 JSON 문자열로 변환하여 저장
            localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(comments));
        }

        const commentList = document.querySelector('.comment-list');
        const moreCommentsBtn = document.querySelector('.more-comments-btn');
        const commentFormContainer = document.querySelector('.comment-form-container');

        /**
         * 평점을 별 문자열로 변환합니다. (정수 별만 표시)
         * @param {number} rating - 평점 (예: 3.5)
         * @returns {string} 별 문자열 (예: "★★★")
         */
        function getStars(rating) {
            const fullStars = Math.floor(rating);
            // 소수점 평점을 제대로 반영하기 위해 반별 로직 추가
            const halfStar = (rating - fullStars >= 0.5) ? '★' : '☆'; // 반별을 '★'로 표시
            return '★'.repeat(fullStars) + (fullStars < 5 && rating - fullStars >= 0.5 ? halfStar : '') + '☆'.repeat(5 - fullStars - (rating - fullStars >= 0.5 ? 1 : 0));
        }

        /**
         * 코멘트 요소를 생성하여 반환합니다.
         * @param {object} comment - 코멘트 데이터 객체
         * @returns {HTMLLIElement} 생성된 li 요소
         */
         function createCommentElement(comment) {
             const li = document.createElement('li');
             const displayContent = comment.content.length > 50
                                     ? comment.content.substring(0, 50) + '...'
                                     : comment.content;

             // JSP EL이 아닌 JavaScript 문자열 연결을 명확히 사용
             li.innerHTML = '<div class="comment-author">' +
                            "'" + comment.author + "'님의 한줄평" +
                            '<span class="rating-stars">' + getStars(comment.rating) + '</span>' +
                            '(평점 : ' + comment.rating.toFixed(1) + ')' +
                            '</div>' +
                            '<div class="comment-content" title="' + comment.content + '">' + displayContent + '</div>';
             return li;
         }

        /**
         * 코멘트 목록을 화면에 표시합니다. (최신순 3개 표시)
         * @param {Array<object>} comments - 코멘트 데이터 배열
         */
        function displayComments(comments) {
            commentList.innerHTML = ''; // 기존 목록 초기화
            // 최신 코멘트부터 보여주기 위해 timestamp를 기준으로 정렬
            const sortedComments = [...comments].sort((a, b) => b.timestamp - a.timestamp);
            const commentsToDisplay = sortedComments.slice(0, 3); // 상위 3개만 선택

            commentsToDisplay.forEach(comment => {
                commentList.appendChild(createCommentElement(comment));
            });

            // 코멘트가 3개 초과 시 '더보기' 버튼 활성화
            if (comments.length > 3) {
                moreCommentsBtn.disabled = false;
            } else {
                moreCommentsBtn.disabled = true;
            }
        }

        // 코멘트 폼 생성 및 삽입
        function createAndAppendCommentForm() {
            const commentFormHTML = `
                <div class="comment-form">
                    <div class="form-rating">
                        <span>평점 : </span>
                        <div class="stars" data-current-rating="5">
                            <span data-value="1">★</span><span data-value="2">★</span><span data-value="3">★</span><span data-value="4">★</span><span data-value="5">★</span>
                        </div>
                    </div>
                    <input type="text" placeholder="코멘트 남기기">
                    <button class="save-btn">저장</button>
                </div>
            `;
            commentFormContainer.insertAdjacentHTML('beforeend', commentFormHTML);

            // 별점 시스템 로직 (클릭 시 별점 변경)
            const starsContainer = commentFormContainer.querySelector('.stars');
            const starSpans = starsContainer.querySelectorAll('span');
            let selectedRating = 5; // 초기 선택 평점

            // 초기 별점 상태 설정
            starSpans.forEach((s, i) => {
                s.textContent = i < selectedRating ? '★' : '☆';
            });

            starSpans.forEach(star => {
                star.addEventListener('mouseover', function() {
                    const value = parseInt(this.dataset.value);
                    starSpans.forEach((s, i) => {
                        s.textContent = i < value ? '★' : '☆';
                    });
                });
                star.addEventListener('mouseout', function() {
                    // 마우스가 별 영역 밖으로 나갔을 때, 현재 선택된 평점으로 다시 표시
                    starSpans.forEach((s, i) => {
                        s.textContent = i < selectedRating ? '★' : '☆';
                    });
                });
                star.addEventListener('click', function() {
                    selectedRating = parseInt(this.dataset.value);
                    starsContainer.dataset.currentRating = selectedRating;
                    // 클릭 즉시 별점 반영
                    starSpans.forEach((s, i) => {
                        s.textContent = i < selectedRating ? '★' : '☆';
                    });
                    console.log('선택된 평점:', selectedRating);
                });
            });

            // 저장 버튼 클릭 이벤트
            const saveBtn = commentFormContainer.querySelector('.save-btn');
            const commentInput = commentFormContainer.querySelector('input[type="text"]');

            saveBtn.addEventListener('click', () => {
                const newContent = commentInput.value.trim();
                if (newContent) {
                    const newComment = {
                        author: '새로운 사용자', // 실제 사용자 이름으로 대체 필요 (예: 로그인된 사용자 이름)
                        rating: selectedRating,
                        content: newContent,
                        timestamp: Date.now() // 현재 시간 기록 (정렬용)
                    };
                    commentData.push(newComment); // 데이터에 추가
                    saveCommentsToLocalStorage(commentData); // 로컬 스토리지에 저장
                    displayComments(commentData); // 목록 새로고침 (초기 3개만 보임)
                    commentInput.value = ''; // 입력창 초기화
                    // 저장 후 별점 초기화
                    selectedRating = 5; // 기본값으로 초기화
                    starsContainer.dataset.currentRating = selectedRating;
                    starSpans.forEach((s, i) => {
                        s.textContent = i < selectedRating ? '★' : '☆';
                    });
                } else {
                    alert('코멘트를 입력해주세요.');
                }
            });
        }

        // DOMContentLoaded 이벤트를 기다려서 요소가 로드된 후 스크립트를 실행합니다.
        document.addEventListener('DOMContentLoaded', () => {
            // 초기 로드 시 코멘트 표시
            displayComments(commentData);
            // 코멘트 폼 생성
            createAndAppendCommentForm();
        });

        // '코멘트 더 보기' 버튼 클릭 이벤트
        moreCommentsBtn.addEventListener('click', () => {
            window.location.href = 'comment.jsp'; // comment.html로 이동
        });
    </script>
    <script src="<%=request.getContextPath()%>/top_menu.js"></script>
    <script src="<%=request.getContextPath()%>/js/footer.js"></script>
</body>
</html>