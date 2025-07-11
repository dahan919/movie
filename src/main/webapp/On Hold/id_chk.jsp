<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String userName = request.getParameter("userName");
	String phone = request.getParameter("phone");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    conn = DriverManager.getConnection(
	        "jdbc:oracle:thin:@localhost:1521:xe",
	        "c##scott", "123456");
	
	    String sql = "SELECT id FROM member WHERE userName=? AND phone=?";
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, userName);
	    pstmt.setString(2, phone);
	
	    rs = pstmt.executeQuery();
	
	    if(rs.next()){
	        String findId = rs.getString("id");
%>
	<script>
	  alert("가입하신 아이디는 '" + "<%=findId%>" + "' 입니다");
	  location.href = "login.do";
	</script>
<%
    } else {
%>
	<script>
	  alert("일치하는 회원 정보가 없습니다.");
	  history.back();
	</script>
<%
	    }
	} catch(Exception e){
	    e.printStackTrace();
%>
	<script>
	  alert("오류가 발생했습니다.");
	  history.back();
	</script>
<%
	} finally {
	    if(rs != null) try { rs.close(); } catch(Exception e){}
	    if(pstmt != null) try { pstmt.close(); } catch(Exception e){}
	    if(conn != null) try { conn.close(); } catch(Exception e){}
	}
%>