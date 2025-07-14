package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.DramaDTO;
import dto.MediaDTO;
import dto.WebtoonDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DramaService;
import service.MediaService;
import service.WebtoonService;
import view.ModelAndView;

public class MainPageController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView view = null;
		
		String mediaImgUrl = request.getParameter("mediaImgUrl");
		String dramaImgUrl = request.getParameter("dramaImgUrl");
		String webtoonImgUrl = request.getParameter("webtoonImgUrl");
		
		if(mediaImgUrl != null) {
			
			List<MediaDTO> mediaList = MediaService.getInstance().selectByUrl(mediaImgUrl);
			JSONArray mediaArray = new JSONArray();
			
			mediaList.forEach(item -> {
				JSONObject obj = new JSONObject();
				obj.put("score", item.getScore());
				obj.put("opendate", item.getOpendate());
				obj.put("story", item.getStory());
				obj.put("poster", item.getPoster());
				obj.put("highlight", item.getHighlight());
				obj.put("title", item.getTitle());
				mediaArray.put(obj);
			});
			
			request.setAttribute("mediaArray", mediaArray);
			
			view = new ModelAndView("detailPageM.jsp", false);
			
		}
		
		if(dramaImgUrl != null) {
			
			List<DramaDTO> dramaList = DramaService.getInstance().selectByUrl(dramaImgUrl);
			
			JSONArray dramaArray = new JSONArray();
			
			dramaList.forEach(item -> {
				JSONObject obj = new JSONObject();
				obj.put("name", item.getName());
				obj.put("overview", item.getOverview());
				obj.put("poster_path", item.getPoster_path());
				obj.put("first_air_date", item.getFirst_air_date());
				dramaArray.put(obj);
			});
			
			request.setAttribute("dramaArray", dramaArray);
			
			view = new ModelAndView("detailPageD.jsp", false);
			
		}
		
		if(webtoonImgUrl != null) {
			
		List<WebtoonDTO> webtoonList = WebtoonService.getInstance().selectByUrl(webtoonImgUrl);
		
		JSONArray webtoonArray = new JSONArray();
		
		webtoonList.forEach(item -> {
			JSONObject obj = new JSONObject();
			obj.put("title", item.getTitle());
			obj.put("thumbnail", item.getThumbnail());
			obj.put("synopsis", item.getSynopsis());
			obj.put("starScoreAverage", item.getStarScoreAverage());
			obj.put("readCount", item.getReadCount());
			obj.put("linkUrl", item.getLinkUrl());
			obj.put("writingAuthorName", item.getWritingAuthorName());
			webtoonArray.put(obj);
		});
		
		request.setAttribute("webtoonArray", webtoonArray);
		
		view = new ModelAndView("detailPageW.jsp", false);
		}
		
		return view;
	}

}
