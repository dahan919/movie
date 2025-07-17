<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>모든 코멘트 - 위플래쉬</title> 
    
    <style>
        /* 기본 초기화 */
        * {
            margin: 0; padding: 0; 
            box-sizing: border-box;
        }
        body {
            font-family: 'Malgun Gothic', sans-serif;
            background-color: #000000;
            color: #FFFFFF; /* 기본 글자색 설정 */
        }
        a { text-decoration: none; color: inherit; }
        ul { list-style: none; }

        /* 상단 메뉴 (detail_page2.html에서 복사) */
        /* header.jsp에서 처리될 부분이므로, 이 CSS는 header.jsp의 CSS에 포함되거나
           menu.css에 이미 정의되어 있어야 합니다. 여기서는 중복을 피하기 위해 제거합니다. */
        
        /* 포스터 배경 */
         .movie-hero {
            position: relative; padding: 80px 20px;
            display: flex; justify-content: center; align-items: center;
            overflow: hidden;
            background-color: #222; /* 배경색으로 블러된 포스터가 보일 수 있도록 어둡게 */
            padding-top: 50px;
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
             color: #ffcc00;
            
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

        /* 코멘트 작성 폼 */
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
            display: flex; 
            flex-wrap: wrap; 
            gap: 20px; 
            padding: 0;
            justify-content: flex-start; /* 좌측 정렬 */
        }
        .comment-list li { 
            background-color: #E6E2D1; 
            border-radius: 8px; 
            padding: 20px;
            flex: 0 0 calc((100% - 40px) / 3); /* 한 줄에 3개 (20px gap * 2) */
            min-width: 280px; /* 개별 코멘트의 최소 너비 */
            box-shadow: 0 2px 4px rgba(0,0,0,0.1); 
            border-bottom: none; 
            display: flex; /* 내부 요소 정렬을 위해 flex 사용 */
            flex-direction: column;
        } 
        @media (max-width: 960px) { /* 태블릿 */
            .comment-list li {
                flex: 0 0 calc((100% - 20px) / 2); /* 한 줄에 2개 */
            }
        }
        @media (max-width: 600px) { /* 모바일 */
            .comment-list li {
                flex: 0 0 100%; /* 한 줄에 1개 */
            }
        }

        .comment-author {
            font-weight: bold; margin-bottom: 10px;
            color: rgb(38, 73, 97); font-size: 14px;
            display: flex;
            align-items: center;
        }
        .comment-author .user-nickname {
            margin-right: 5px;
            font-size: 1.1em;
            color: #000;
        }
        .comment-content {
            font-size: 16px; color: #333;
            white-space: pre-wrap; /* 줄 바꿈 유지 */
            word-break: break-word; /* 긴 단어 강제 줄 바꿈 */
            flex-grow: 1; /* 내용이 길어져도 레이아웃 유지 */
            margin-bottom: 10px;
        }
        .comment-meta {
            font-size: 0.85em;
            color: #666;
            margin-top: auto; /* 하단으로 정렬 */
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
     <div class="wrapper">
      <div class="container">
         <div class="main_container">
            <jsp:include page="./WEB-INF/views/template/header.jsp"></jsp:include>
   </div>
</div>
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
        <div class="comments-header">
            <h2>모든 코멘트</h2> 
            </div>
            <%-- 코멘트 작성 폼을 이 섹션 안에 배치합니다. --%>
            <div class="comment-form-container">
            <div class="comment-form">
                <div class="form-rating">
                    <span>평점 : </span>
                    <div class="stars" data-current-rating="5">
                        <span data-value="1">★</span><span data-value="2">★</span><span data-value="3">★</span><span data-value="4">★</span><span data-value="5">★</span>
                    </div>
                </div>
                <input type="text" id="commentInput" placeholder="코멘트를 남겨주세요.">
                <button class="save-btn" id="saveCommentBtn">저장</button>
            </div>
            </div>
            <ul class="comment-list"></ul>
        </section>
		
        <section class="back-button-container">
            <button class="back-btn">돌아가기</button> 
        </section> 
        
    </main>
<jsp:include page="./WEB-INF/views/template/footer.jsp"></jsp:include>
     <script>
        // JSP에서 받아온 영화 ID를 JavaScript 변수에 할당합니다.
        const currentMovieId = "<%= request.getParameter("movieId") %>";
        // 또는 pageContext에 저장한 EL로 가져올 수도 있습니다.
        // const currentMovieId = "${currentMovieId}";

        const commentList = document.querySelector('.comment-list');
        const backBtn = document.querySelector('.back-btn');
        const commentFormContainer = document.querySelector('.comment-form-container');
        const commentInput = document.getElementById('commentInput');
        const saveCommentBtn = document.getElementById('saveCommentBtn');
        const starsContainer = commentFormContainer.querySelector('.stars');
        const starSpans = starsContainer.querySelectorAll('span');

        let selectedRating = 5; // 초기 선택 평점

        // ... (getStars, initializeStarRating, createCommentElement, displayComments 함수 동일) ...

        // 서버에서 모든 코멘트 데이터를 불러오는 함수 (GET 요청)
        async function fetchCommentsFromServer() {
            if (!currentMovieId || currentMovieId === "null" || currentMovieId === "0") {
                commentList.innerHTML = '<p style="text-align: center; color: red;">유효한 영화 ID가 없습니다. 댓글을 불러올 수 없습니다.</p>';
                console.error("No valid movieId provided.");
                return;
            }

            commentList.innerHTML = '<p style="text-align: center; color: #fff;">코멘트 로딩 중...</p>';

            try {
                // 영화 ID를 URL 경로에 포함하여 요청
                // 예: /api/comments/123
                const response = await fetch(`/api/comments/${currentMovieId}`, {
                    method: 'GET',
                    headers: {
                        'Accept': 'application/json'
                    }
                });

                if (!response.ok) {
                    throw new Error(`HTTP 오류! 상태: ${response.status}`);
                }

                const comments = await response.json();
                displayComments(comments);

            } catch (error) {
                console.error('코멘트 불러오기 실패:', error);
                commentList.innerHTML = '<p style="text-align: center; color: red;">코멘트를 불러오는 데 실패했습니다: ' + error.message + '</p>';
            }
        }

        // 새 코멘트를 서버에 전송하는 함수 (POST 요청)
        async function postNewComment(newCommentData) {
            if (!currentMovieId || currentMovieId === "null" || currentMovieId === "0") {
                alert('유효한 영화 ID가 없습니다. 댓글을 저장할 수 없습니다.');
                return;
            }

            try {
                // 댓글 작성 시에도 영화 ID를 함께 전달해야 합니다.
                // 컨트롤러가 JSON body를 받을 때 movie_id 필드를 DTO에 포함시키거나,
                // URL 경로에 movie_id를 포함시킬 수 있습니다. 여기서는 DTO에 포함하는 방식을 가정합니다.
                // 또는 `/commentWrite/${currentMovieId}` 와 같이 URL에 넣을 수도 있습니다.

                const response = await fetch('commentWrite', { 
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'Accept': 'application/json'
                    },
                    body: JSON.stringify({
                        ...newCommentData, // 기존 코멘트 데이터 (score_c, criticism, u_num, nickname)
                        movie_id: currentMovieId // 댓글 작성 시 영화 ID 추가
                    })
                });

                if (!response.ok) {
                    const errorText = await response.text();
                    throw new Error(`HTTP 오류! 상태: ${response.status}, 응답: ${errorText}`);
                }

                const result = await response.json();
                console.log('코멘트 저장 성공:', result);
                alert('코멘트가 성공적으로 저장되었습니다!');
                fetchCommentsFromServer(); // 저장 후 코멘트 목록 새로고침
                commentInput.value = '';
                selectedRating = 5;
                initializeStarRating();
            } catch (error) {
                console.error('코멘트 저장 실패:', error);
                alert('코멘트 저장에 실패했습니다: ' + error.message);
            }
        }


        // 페이지 로드 시 초기화
        document.addEventListener('DOMContentLoaded', () => {
            initializeStarRating();
            fetchCommentsFromServer();
        });


        // 저장 버튼 클릭 이벤트
        saveCommentBtn.addEventListener('click', () => {
            const commentContent = commentInput.value.trim();

            if (!commentContent) {
                alert('코멘트를 입력해주세요.');
                return;
            }

            const userNickname = "<%= session.getAttribute("nickname") != null ? session.getAttribute("nickname") : "익명" %>";
            const userNum = "<%= session.getAttribute("user_num") != null ? session.getAttribute("user_num") : 0 %>";

            const newComment = {
                u_num: userNum,
                nickname: userNickname,
                score_c: selectedRating,
                criticism: commentContent
            };
            postNewComment(newComment);
        });

        // '돌아가기' 버튼 클릭 이벤트
        if (backBtn) {
            backBtn.addEventListener('click', () => {
                // detailPage.jsp로 돌아갈 때도 현재 영화 ID를 함께 전달할 수 있습니다.
                window.location.href = `detailPage.jsp?movieId=${currentMovieId}`;
            });
        }

        // --- 기존 코드에서 변경 없는 함수들 ---
        function getStars(rating) {
            const fullStars = Math.floor(rating);
            const emptyStars = 5 - fullStars;
            return '★'.repeat(fullStars) + '☆'.repeat(emptyStars);
        }

        function initializeStarRating() {
            starSpans.forEach((s, i) => {
                s.textContent = i < selectedRating ? '★' : '☆';
                s.classList.toggle('selected', i < selectedRating);
            });

            starSpans.forEach(star => {
                star.addEventListener('mouseover', function() {
                    const value = parseInt(this.dataset.value);
                    starSpans.forEach((s, i) => {
                        s.textContent = i < value ? '★' : '☆';
                        s.classList.toggle('selected', i < value);
                    });
                });
                star.addEventListener('mouseout', function() {
                    starSpans.forEach((s, i) => {
                        s.textContent = i < selectedRating ? '★' : '☆';
                        s.classList.toggle('selected', i < selectedRating);
                    });
                });
                star.addEventListener('click', function() {
                    selectedRating = parseInt(this.dataset.value);
                    starsContainer.dataset.currentRating = selectedRating;
                    starSpans.forEach((s, i) => {
                        s.textContent = i < selectedRating ? '★' : '☆';
                        s.classList.toggle('selected', i < selectedRating);
                    });
                    console.log('선택된 평점:', selectedRating);
                });
            });
        }

        function createCommentElement(comment) {
            const li = document.createElement('li');
            li.className = 'comment-item';

            const starsHtml = getStars(comment.score_c);
            const formattedScore = (comment.score_c !== undefined) ? comment.score_c.toFixed(1) : 'N/A';
            const formattedDate = comment.writedate ? new Date(comment.writedate).toLocaleString('ko-KR') : '날짜 없음';

            let htmlContent = '';
            htmlContent += '<div class="comment-author">';
            htmlContent += '<span class="user-nickname">' + (comment.nickname || '익명') + '</span>';
            htmlContent += '<span class="rating-stars">' + starsHtml + '</span> ';
            htmlContent += '(평점 : ' + formattedScore + ')';
            htmlContent += '</div>';
            htmlContent += '<div class="comment-content">' + (comment.criticism || '내용 없음') + '</div>';
            htmlContent += '<div class="comment-meta">';
            htmlContent += '작성일: ' + formattedDate;
            htmlContent += ' (댓글 번호: ' + (comment.c_num || 'N/A') + ')';
            htmlContent += '</div>';

            li.innerHTML = htmlContent;
            return li;
        }

        function displayComments(comments) {
            commentList.innerHTML = '';

            if (comments && comments.length > 0) {
                comments.sort((a, b) => new Date(b.writedate) - new Date(a.writedate));

                comments.forEach(comment => {
                    const commentElement = createCommentElement(comment);
                    commentList.appendChild(commentElement);
                });
            } else {
                commentList.innerHTML = '<p style="text-align: center; color: #aaa;">아직 코멘트가 없습니다. 첫 코멘트를 남겨주세요!</p>';
            }
        }

    </script>

</body>
</html>