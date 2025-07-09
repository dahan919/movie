package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MediaService;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.MediaDTO;

/**
 * Servlet implementation class SelectMediaServlet
 */
@WebServlet("/SelectMediaServlet")
public class SelectMediaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//select문은 doGet method로 작업
    public SelectMediaServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. List로 DTO의 값 이용해서 받아오기
		List<MediaDTO> mediaList = MediaService.getInstance().selectAllMedia();
		
		//2. JsonArray 객체 생성
		JSONArray arr = new JSONArray();
		
		//3. JSON 객체를 생성후 list로 꺼내온 정보들을 key, value값으로 넣기
		mediaList.forEach(item -> {
			JSONObject json = new JSONObject();
			json.put("mnum", item.getM_num());
			json.put("score", item.getScore());
			json.put("opendate", item.getOpendate());
			json.put("story", item.getStory());
			json.put("poster", item.getPoster());
			json.put("highlight", item.getHighlight());
			json.put("title", item.getTitle());
			arr.put(json);
		});
		
		//4. 출력
		response.setContentType("application/json; charset-UTF-8");
		response.getWriter().println(arr.toString());
	}

}