package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CommentaryService;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.CommentaryDTO;

/**
 * Servlet implementation class SelectCommentaryServlet
 */
@WebServlet("/SelectCommentaryServlet")
public class SelectCommentaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Select문은 doGet method 선택해서 작업
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. CommentaryDTO class를 이용, Commentary Service의 selectAllCommentary method를 호출
		List<CommentaryDTO> commentaryList = CommentaryService.getInstance().selectAllCommentary();
		
		//2. JSONArray 객체 생성
		JSONArray jsonArray = new JSONArray();
		
		for (CommentaryDTO commentary: commentaryList) {
			//비어있는 json객체를 하나 생성
			JSONObject json = new JSONObject();
			//객체에 key, value값을 지정하여 값들을 넣어줌
			json.put("c_num", commentary.getC_num());
			json.put("u_num", commentary.getU_num());
			json.put("m_num", commentary.getM_num());
			json.put("criticism", commentary.getCriticism());
			json.put("score_c", commentary.getScore_c());
			json.put("writedate", commentary.getWritedate());
			//JSONArray는 실제 값을 넣음
			jsonArray.put(json);
		}
		
		//3. 변환한 파일을 response로 써줌 
		response.setContentType("application/json; charset-UTF-8");
		response.getWriter().println(jsonArray.toString());
	}

}
