<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>관리자 페이지</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #fffdf0;
      margin: 0;
      padding: 0;
    }

    .container {
      max-width: 600px;
      margin: 0 auto;
      padding-top: 30px;
    }

    .header {
      text-align: center;
      margin-bottom: 20px;
      color: #333;
    }

    .tabs-wrapper {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin-bottom: 20px;
      flex-wrap: wrap;
      gap: 10px;
    }

    .tabs {
      display: flex;
      flex-wrap: wrap;
      gap: 10px;
    }

    .tab {
      padding: 10px 18px;
      border: 1px solid #aaa;
      border-radius: 5px;
      background-color: transparent;
      color: #333;
      font-weight: bold;
      cursor: pointer;
      text-decoration: none;
    }

    .tab:hover {
      background-color: #f2f2f2;
    }

    .tab-content {
      display: none;
    }

    .tab-search {
      text-align: center;
      margin-bottom: 20px;
    }

    .tab-search input {
      padding: 10px;
      width: 250px;
      border-radius: 5px;
      border: 1px solid #ddd;
    }

    .tab-search button {
      padding: 10px;
      background-color: #ddd;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    .tab-search button:hover {
      background-color: #bbb;
    }

    ul {
      padding: 0;
      list-style-type: none;
      margin: 0;
    }

    li {
      background-color: white;
      border: 1px solid #ddd;
      margin: 5px 0;
      padding: 10px;
      border-radius: 5px;
    }

    .li-buttons {
      margin-top: 10px;
    }

    button {
      padding: 5px 10px;
      background-color: #0074D9;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      margin-right: 10px;
    }

    button:hover {
      background-color: #005fa3;
    }

    .modal {
      display: none;
      position: fixed;
      z-index: 1000;
      left: 0;
      top: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.5);
    }

    .modal-content {
      background-color: white;
      margin: 15% auto;
      padding: 20px;
      border-radius: 10px;
      width: 300px;
      text-align: center;
    }

    .modal-content button {
      margin: 10px;
    }

    .modal-content button.delete {
      background-color: #dc3545;
    }

    .modal-content button.delete:hover {
      background-color: #c82333;
    }
  </style>
</head>
<body>
<div class="container">
  <div class="header"><h1>관리자 페이지</h1></div>

  <div class="tabs-wrapper">
    <div class="tabs">
      <div class="tab" onclick="showTab('member')">회원관리</div>
      <div class="tab" onclick="showTab('content')">콘텐츠 관리</div>
      <div class="tab" onclick="showTab('comment')">댓글 관리</div>
      <div class="tab" onclick="showTab('notice')">공지사항 관리</div>
    </div>
    <a href="notice.jsp" class="tab">쓰기</a>
  </div>

  <div id="member" class="tab-content">
    <div class="tab-search">
      <input type="text" placeholder="회원 검색..." />
      <button>검색</button>
    </div>
    <ul id="memberList">
      <li>
        회원 A
        <div class="li-buttons">
          <button onclick="showDeleteModal(this)">삭제</button>
        </div>
      </li>
      <li>
        회원 B
        <div class="li-buttons">
          <button onclick="showDeleteModal(this)">삭제</button>
        </div>
      </li>
    </ul>
  </div>

  <div id="content" class="tab-content">
    <div class="tab-search">
      <input type="text" placeholder="콘텐츠 검색..." />
      <button>검색</button>
    </div>
    <ul id="contentList">
      <li>
        영화 A 등록됨
        <div class="li-buttons">
          <button onclick="showDeleteModal(this)">삭제</button>
        </div>
      </li>
      <li>
        드라마 B 등록됨
        <div class="li-buttons">
          <button onclick="showDeleteModal(this)">삭제</button>
        </div>
      </li>
    </ul>
  </div>

  <div id="comment" class="tab-content">
    <div class="tab-search">
      <input type="text" placeholder="댓글 검색..." />
      <button>검색</button>
    </div>
    <ul id="commentList">
      <li>
        회원 A: 이 영화 너무 좋아요
        <div class="li-buttons">
          <button onclick="showDeleteModal(this)">삭제</button>
        </div>
      </li>
      <li>
        회원 B: 별로에요
        <div class="li-buttons">
          <button onclick="showDeleteModal(this)">삭제</button>
        </div>
      </li>
    </ul>
  </div>

  <div id="notice" class="tab-content">
    <div class="tab-search">
      <input type="text" placeholder="공지사항 검색..." />
      <button>검색</button>
    </div>
    <ul id="adminNoticeList"></ul>
  </div>
</div>

<!-- 삭제 확인 모달 -->
<div id="deleteModal" class="modal">
  <div class="modal-content">
    <h3>⚠️ 정말 삭제하시겠습니까?</h3>
    <button class="delete" onclick="confirmDelete()">삭제</button>
    <button onclick="closeDeleteModal()">취소</button>
  </div>
</div>

<script>
  let deleteTarget = null;
  let deleteIndex = null;

  function loadAdminNotices() {
    const list = document.getElementById('adminNoticeList');
    list.innerHTML = '';
    const notices = JSON.parse(localStorage.getItem('notices') || '[]');

    if (notices.length === 0) {
      list.innerHTML = '<p>등록된 공지사항이 없습니다.</p>';
      return;
    }

    notices.forEach((notice, index) => {
      const li = document.createElement('li');
      li.innerHTML =
        '<strong>제목:</strong> ' + notice.title + '<br>' +
        '<strong>내용:</strong> ' + notice.content + '<br>' +
        '<strong>작성일자:</strong> ' + notice.date + '<br>' +
        '<div class="li-buttons">' +
          '<button onclick="editNotice(' + index + ')">수정</button>' +
          '<button onclick="deleteNotice(' + index + ')">삭제</button>' +
        '</div>';
      list.appendChild(li);
    });
  }

  function editNotice(index) {
	    localStorage.setItem('editIndex', index);
	    window.location.href = 'notice.jsp';
	  }

  function deleteNotice(index) {
    deleteIndex = index;
    deleteTarget = null;
    document.getElementById('deleteModal').style.display = 'block';
  }

  function showDeleteModal(button) {
    deleteTarget = button.closest('li');
    deleteIndex = null;
    document.getElementById('deleteModal').style.display = 'block';
  }

  function confirmDelete() {
    if (deleteTarget) {
      deleteTarget.remove();
    }
    if (deleteIndex !== null) {
      const notices = JSON.parse(localStorage.getItem('notices') || '[]');
      notices.splice(deleteIndex, 1);
      localStorage.setItem('notices', JSON.stringify(notices));
      loadAdminNotices();
    }
    closeDeleteModal();
  }

  function closeDeleteModal() {
    document.getElementById('deleteModal').style.display = 'none';
    deleteTarget = null;
    deleteIndex = null;
  }

  function showTab(tabName) {
    const tabs = document.querySelectorAll('.tab-content');
    tabs.forEach(function(tab) {
      tab.style.display = 'none';
    });
    const target = document.getElementById(tabName);
    if (target) {
      target.style.display = 'block';
      if (tabName === 'notice') loadAdminNotices();
    }
  }

  window.onload = function () {
    const params = new URLSearchParams(window.location.search);
    const tabName = params.get('tab') || 'member';
    showTab(tabName);
  };
</script>

</body>
</html>
