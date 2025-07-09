<%@ page contentType="text/html; charset=UTF-8"%> 

	<% 
		String inputId = request.getParameter("id"); 
		String inputPasswd = request.getParameter("passwd");
		String userId = "admin"; 
		String userPasswd = "1234"; 
		
		if(userId.equals(inputId) && userPasswd.equals(inputPasswd)){ 
		%>
		<script>
		  alert("로그인 성공");
		  location.href = "main.jsp";
		</script>
		<% 
		} else { 
		%>
		<script>
		  alert("아이디 또는 비밀번호가 틀렸습니다.");
		  history.back();
		</script>
	<% } 
	%>
