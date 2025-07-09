<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String id = request.getParameter("id");
    String phone = request.getParameter("phone");
    String passWd1 = request.getParameter("passWd1");
    String passWd2 = request.getParameter("passWd2");

    if(passWd1 == null || passWd1.length() < 8 || passWd1.length() > 12) {
%>
	<script>
	    alert("비밀번호는 8~12자로 입력해주세요.");
	    history.back();
	</script>
	<%
        return;
    }

    if(passWd1.equals(passWd2)){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "c##scott", "123456");

            String sql = "UPDATE member SET passwd=? WHERE id=? AND phone=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, passWd1);
            pstmt.setString(2, id);
            pstmt.setString(3, phone);

            int result = pstmt.executeUpdate();
            if(result > 0){
%>
<script>
    alert("비밀번호 변경에 성공했습니다.");
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
            if(pstmt != null) try { pstmt.close(); } catch(Exception e){}
            if(conn != null) try { conn.close(); } catch(Exception e){}
        }
    } else {
%>
<script>
    alert("비밀번호가 맞지 않습니다.");
    history.back();
</script>
<%
    }
%>