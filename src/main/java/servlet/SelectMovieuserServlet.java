package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MovieuserService;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.MovieuserDTO;

@WebServlet("/SelectMovieuserServlet")
public class SelectMovieuserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SelectMovieuserServlet() {}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.DB에서 데이터 꺼내와서 list로 만들기
		List<MovieuserDTO> movieUserList = MovieuserService.getInstance().selectAllMovieuser();
		
		//2.JSONArray 객체 하나생성
		//여기에 넣어 데이터 보낼거임
		JSONArray arr = new JSONArray();
		
		//3. movieUserList에 들어있는 데이터 꺼내서 JSON의 빈 객체에 넣은 후, JSON의 객체를 JSONArray에 넣음
		movieUserList.forEach(item -> {
			JSONObject json = new JSONObject();
			json.put("u_num", item.getU_num());
			json.put("name", item.getName());
			json.put("nickNm", item.getNickNm());
			json.put("passwd", item.getPasswd());
			json.put("id", item.getId());
			arr.put(json);
		});
		
		//4. 데이터를 response에 넣어서 보내기
		response.setContentType("application/json; charset-UTF-8");
		response.getWriter().println(arr.toString());
	}

}
