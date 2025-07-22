<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>공지사항</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      font-family: 'Malgun Gothic', sans-serif;
      background-color: black;
      margin: 0;
      padding: 30px 0;
    }

    .container {
      max-width: 700px;
      margin: 0 auto;
      padding: 0 20px;
    }

    h1 {
      text-align: center;
      margin-bottom: 30px;
      color: #ffc60a;
    }

    .notice {
      background: white; 
      border: 1px solid #ddd;
      padding: 20px;
      border-radius: 10px;
      margin-bottom: 20px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.05);
    }

    .notice h3 {
      margin: 0 0 10px;
      color: #ffc60a;
    }

    .notice p {
      margin: 5px 0;
      font-size: 14px;
    }

    .notice .date {
      font-size: 12px;
      color: gray;
      text-align: right;
    }
  </style>
</head>
<body>

  <div class="container">
    <h1>📢 공지사항</h1>
    <div id="noticeList"></div>
  </div>

  <script>
const noticeList = document.getElementById('noticeList');

// 서버에서 공지사항 목록 받아오기 (AJAX)
fetch("./user-notice.do")
  .then(response => response.json())
  .then(notices => {
    // 최신 날짜순 정렬
    notices.sort(function(a, b) {
      return new Date(b.a_date) - new Date(a.a_date);
    });

    if (notices.length === 0) {
      noticeList.innerHTML = '<p>등록된 공지사항이 없습니다.</p>';
    } else {
      notices.forEach(function(notice) {
        const div = document.createElement('div');
        div.className = 'notice';
        div.innerHTML =
          '<h3>' + notice.a_title + '</h3>' +
          '<p>' + notice.a_content + '</p>' +
          '<p class="date">작성일자: ' + notice.a_date + '</p>';
        noticeList.appendChild(div);
      });
    }
  })
  .catch(err => {
    noticeList.innerHTML = '<p>공지사항을 불러오는 데 실패했습니다.</p>';
    console.error(err);
  });
</script>


</body>
</html>
