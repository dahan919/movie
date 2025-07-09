<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>관리자 페이지</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }
    h2 {
      margin-top: 40px;
    }
    table {
      border-collapse: collapse;
      width: 90%;
      margin: 20px auto;
    }
    th, td {
      border: 1px solid #ddd;
      padding: 10px;
      text-align: center;
    }
    th {
      background-color: #f4f4f4;
    }
  </style>
</head>
<body>

  <h2>🙋‍♀️ 회원 목록</h2>
  <table>
    <tr>
      <th>회원번호</th>
      <th>이름</th>
      <th>닉네임</th>
      <th>아이디</th>
      <th>비밀번호</th>
    </tr>
    <c:forEach var="user" items="${movieuserList}">
      <tr>
        <td>${user.u_num}</td>
        <td>${user.name}</td>
        <td>${user.nickNm}</td>
        <td>${user.id}</td>
        <td>${user.passwd}</td>
      </tr>
    </c:forEach>
  </table>

  <h2>💬 댓글 목록</h2>
  <table>
    <tr>
      <th>댓글번호</th>
      <th>회원번호</th>
      <th>미디어번호</th>
      <th>내용</th>
      <th>평점</th>
      <th>작성일</th>
    </tr>
    <c:forEach var="comment" items="${commentaryList}">
      <tr>
        <td>${comment.c_num}</td>
        <td>${comment.u_num}</td>
        <td>${comment.m_num}</td>
        <td>${comment.criticism}</td>
        <td>${comment.score_c}</td>
        <td>${comment.writedate}</td>
      </tr>
    </c:forEach>
  </table>

  <h2>🎬 미디어 목록</h2>
  <table>
    <tr>
      <th>미디어번호</th>
      <th>제목</th>
      <th>평점</th>
      <th>개봉일</th>
      <th>줄거리</th>
      <th>포스터</th>
      <th>하이라이트</th>
    </tr>
    <c:forEach var="media" items="${mediaList}">
      <tr>
        <td>${media.m_num}</td>
        <td>${media.title}</td>
        <td>${media.score}</td>
        <td>${media.opendate}</td>
        <td>${media.story}</td>
        <td>
          <c:if test="${media.poster != null}">
            <img src="data:image/jpeg;base64,${media.posterBase64}" width="80" />
          </c:if>
        </td>
        <td>
          <c:if test="${media.highlight != null}">
            (영상 있음)
          </c:if>
        </td>
      </tr>
    </c:forEach>
  </table>

</body>
</html>