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
      margin: 30px auto 0 auto;
      background: white;
      padding: 30px 25px 25px 25px;
      border-radius: 10px;
      box-shadow: 0 4px 10px rgba(0,0,0,0.1);
      display: flex;
      flex-direction: column;
      gap: 18px;
    }
    label {
      font-weight: bold;
      font-size: 20px;
      margin-bottom: 5px;
    }
    input[type="text"], textarea {
      border: 1.5px solid #ffc60a;
      border-radius: 8px;
      padding: 10px 12px;
      font-size: 16px;
      margin-bottom: 3px;
      outline: none;
      transition: border 0.2s;
      background: #f9f8f3;
    }
    input[type="text"]:focus, textarea:focus {
      border: 2px solid #ffc60a;
      background: #fff8e1;
    }
    textarea {
      resize: vertical;
      min-height: 90px;
      font-family: 'Malgun Gothic', sans-serif;
    }
    button {
      background: #ffc60a;
      color: #212121;
      font-size: 19px;
      font-weight: bold;
      border: none;
      border-radius: 8px;
      padding: 12px 0;
      cursor: pointer;
      margin-top: 10px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.04);
      transition: background 0.2s;
    }
    button:hover {
      background: #ffd700;
    }
    /* Custom Alert Modal */
    #customAlert {
      display: none;
      position: fixed;
      left: 0; top: 0; right: 0; bottom: 0;
      background: rgba(0,0,0,0.25);
      z-index: 1000;
      align-items: center;
      justify-content: center;
    }
    #customAlert.show {
      display: flex;
    }
    #customAlert > div, #customAlert > p, #customAlert > button {
      /* for safety, reset margin/padding */
      margin: 0; padding: 0;
    }
    #customAlertContent {
      background: #fff;
      border-radius: 13px;
      padding: 32px 32px 22px 32px;
      min-width: 230px;
      text-align: center;
      box-shadow: 0 4px 20px rgba(0,0,0,0.08);
      border: 2.5px solid #ffc60a;
    }
    #alertMessage {
      font-size: 18px;
      margin-bottom: 16px;
      color: #212121;
      font-weight: 500;
    }
    #customAlert button {
      width: 100%;
      border-radius: 8px;
      background: #ffc60a;
      color: #212121;
      font-size: 17px;
      font-weight: bold;
      border: none;
      padding: 10px 0;
      margin: 0;
    }
  </style>
</head>
<body>

  <header><h1>✍🏻 공지사항 작성</h1></header>

  <div class="container">
      <label for="title">제목</label>
      <input type="text" id="title" name="a_title" required>

      <label for="content">공지내용</label>
      <textarea id="content" name="a_content" required></textarea>

      <button type="button" onclick="submitNoticeForm()">저장</button>
  </div>

  <div id="customAlert">
    <p id="alertMessage"></p>
    <button onclick="closeAlert()">확인</button>
  </div>

 

</body>

<script type="text/javascript">

function submitNoticeForm(e) {
	
	  // 입력값 가져오기
	  const title = document.getElementById('title').value;
	  const content = document.getElementById('content').value;

	  console.log('a_title',title)
	   console.log('a_content',content)
	  
	  // GET 쿼리 스트링 생성
	  const params = new URLSearchParams({
	    a_title: title,
	    a_content: content
	  }).toString();

	  console.log('파람',params)
	  
	  // ★★★ 이 부분이 GET 방식! ★★★
	  fetch('./writeNotice.do?' + params) // GET 방식 AJAX 요청
	    .then(data => {
	    
	      alert('저장되었습니다!');
	      window.location.href = "./adminForm.do";
	    })
	    .catch(error => {
	      alert('오류 발생: ' + error);
	    });
	}

</script>

</html>
