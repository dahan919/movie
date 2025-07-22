package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.CommentaryDTO;
import dto.DramaDTO;
import dto.MediaDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CommentaryService;
import service.DramaService;
import service.MediaService;
import view.ModelAndView;

public class CategoryMController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView view = null;
		
		//+alpha) api값 받아오기
		String apiResult = MediaService.getInstance().search(null);
		
		List<MediaDTO> mList = MediaService.getInstance().StringToJSON(apiResult);
		
		JSONArray apiArray = new JSONArray(mList);
		
		String title = request.getParameter("title");
		
		//1.DB에서 데이터 꺼내오기
		List<MediaDTO> mediaList = MediaService.getInstance().selectByTitle(title);
		
		//2.꺼낸 데이터 request 객체에 넣어주기
		JSONArray array = new JSONArray(mediaList);
		
		//3.JSONObject만들어서 배열 2개 넣기 
		JSONObject obj = new JSONObject();
		obj.put("apiArray", apiArray);
		obj.put("array", array);
		
		//3.페이지로 보내주기
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().println(obj.toString());
		
		return view;
	}

}
