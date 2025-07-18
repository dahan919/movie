package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.CommentaryDTO;
import dto.MediaDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CommentaryService;
import service.MediaService;
import view.ModelAndView;

public class CategoryMController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView view = null;
		
		String title = request.getParameter("title");
		
		//1.DB에서 데이터 꺼내오기
		List<MediaDTO> mediaList = MediaService.getInstance().selectByTitle(title);
		
		//2.꺼낸 데이터 request 객체에 넣어주기
		JSONArray array = new JSONArray(mediaList);
		
		
		//3.페이지로 보내주기
		response.getWriter().println(array.toString());
		
		return view;
	}

}
