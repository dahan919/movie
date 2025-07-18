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
      background-color: #ffc60a;
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
    <form id="noticeForm" action="./writeNotice.do">
      <label for="title">제목</label>
      <input type="text" id="title" name="a_title" required>

      <label for="content">공지내용</label>
      <textarea id="content" name="a_content" required></textarea>

      <button type="submit">저장</button>
    </form>
  </div>

  <div id="customAlert">
    <p id="alertMessage"></p>
    <button onclick="closeAlert()">확인</button>
  </div>

 

</body>
</html>
