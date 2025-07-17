<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>공지사항 작성</title>
  <style>
    body {
      font-family: 'Malgun Gothic', sans-serif;
      background-color: black;
      margin: 0;
      padding: 0;
    }
    header {
      color: #ffc60a;
      padding: 20px;
      text-align: center;
      font-weight: bold;
    }

    .container {
      max-width: 480px;
      margin: 0 auto;
      background: white;
      padding: 25px;
      border-radius: 10px;
      box-shadow: 0 4px 10px rgba(0,0,0,0.1);
    }
    form {
      display: flex;
      flex-direction: column;
    }
    label {
      margin: 10px 0 5px;
      font-weight: bold;
      font-size: 20px;
    }
    input, textarea {
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 5px;
      font-size: 14px;
    }
    textarea {
      resize: vertical;
      min-height: 80px;
    }
    button {
      margin-top: 20px;
      padding: 10px;
      background-color: #ffc60a;
      color: white;
      border: none;
      border-radius: 5px;
      font-size: 15px;
      cursor: pointer;
    }
    button:hover {
      background-color: black;
    }
    #customAlert {
      display: none;
      position: fixed;
      top: 30%;
      left: 50%;
      transform: translate(-50%, -50%);
      background: white;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 10px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
      z-index: 1000;
      width: 300px;
      text-align: center;
    }
    #customAlert button {
      margin-top: 15px;
      padding: 8px 20px;
      background-color: #0074D9;
      color: white;
      border: none;
      border-radius: 5px;
      font-size: 14px;
      cursor: pointer;
    }
  </style>
</head>
<body>

  <header><h1>✍🏻 공지사항 작성</h1></header>

  <div class="container">
    <form id="noticeForm">
      <label for="title">제목</label>
      <input type="text" id="title" name="title" required>

      <label for="content">공지내용</label>
      <textarea id="content" name="content" required></textarea>

      <button type="submit">저장</button>
    </form>
  </div>

  <div id="customAlert">
    <p id="alertMessage"></p>
    <button onclick="closeAlert()">확인</button>
  </div>

  <script>
  function showAlert(message) {
    document.getElementById("alertMessage").innerText = message;
    document.getElementById("customAlert").style.display = "block";
  }

  function closeAlert() {
    document.getElementById("customAlert").style.display = "none";
    window.location.href = "admin.jsp?tab=member";  // 저장 후 회원관리 탭으로 이동
  }

  const form = document.getElementById('noticeForm');
  const titleInput = document.getElementById('title');
  const contentInput = document.getElementById('content');

  const editIndex = localStorage.getItem('editIndex');
  const notices = JSON.parse(localStorage.getItem('notices') || '[]');

  if (editIndex !== null && notices[editIndex]) {
    const notice = notices[editIndex];
    titleInput.value = notice.title;
    contentInput.value = notice.content;
  }

  form.addEventListener('submit', function(e) {
    e.preventDefault();

    const title = titleInput.value.trim();
    const content = contentInput.value.trim();
    const today = new Date().toISOString().slice(0, 10); // YYYY-MM-DD

    if (!title || !content) {
      alert('제목과 내용을 모두 입력해주세요.');
      return;
    }

    const newNotice = { title: title, content: content, date: today };

    if (editIndex !== null && notices[editIndex]) {
      notices[editIndex] = newNotice;
      localStorage.removeItem('editIndex');
    } else {
      notices.unshift(newNotice);
    }

    localStorage.setItem('notices', JSON.stringify(notices));

    showAlert('📌 저장된 내용\n\n제목: ' + title + '\n내용: ' + content + '\n작성일자: ' + today);
  });
</script>

</body>
</html>
