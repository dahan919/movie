package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.DramaDTO;
import dto.WebtoonDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DramaService;
import service.WebtoonService;
import view.ModelAndView;

public class CategoryWController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ModelAndView view = null;
		
		//1.DB에서 데이터 꺼내오기
		List<WebtoonDTO> webtoonList = WebtoonService.getInstance().selectAll();
		
		//2.꺼낸 데이터 JSON으로 변환
		JSONArray array = new JSONArray();
		webtoonList.forEach(item -> {
			JSONObject obj = new JSONObject();
			obj.put("title", item.getTitle());
			obj.put("thumbnail", item.getThumbnail());
			obj.put("synopsis", item.getSynopsis());
			obj.put("starScoreAverage", item.getStarScoreAverage());
			obj.put("readCount", item.getReadCount());
			obj.put("linkUrl", item.getLinkUrl());
			obj.put("writingAuthorName", item.getWritingAuthorName());
			array.put(obj);
		});
		
		//3.데이터 AJAX로 페이지로 보내주기
		response.getWriter().print(array.toString());
		
		return view;
		
	}

}
