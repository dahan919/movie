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

		//1. 통합 검색 기능
		ModelAndView view = null;
		
		String search = request.getParameter("search");
		
		if (search != null) {
			//search 데이터
			String mediaResult = MediaService.getInstance().search(search);
			String dramaResult = DramaService.getInstance().search(search);
			
			//데이터 타입 변환: String -> JSON -> List(JSON까지만 변환?)
			List<MediaDTO> mList = MediaService.getInstance().StringToJSON(mediaResult);
			List<DramaDTO> dList = DramaService.getInstance().StringToJSON(dramaResult);
			
			//받은 데이터 삽입
			int mn = MediaService.getInstance().insertSearchResult(mList);
			int dn = DramaService.getInstance().insertSearchResult(dList);
			
			//데이터 앞으로 보내주기
			if(mn != 0 || dn != 0 || wn != 0) {
				
				JSONArray mediaArray = new JSONArray(mList);
				JSONArray dramaArray = new JSONArray(dList);
				
				JSONObject obj = new JSONObject();
				obj.put("mediaArray", mediaArray);
				obj.put("dramaArray", dramaArray);
				
				response.getWriter().println(obj);
			}
			
		}
		
		return view;
	}
}
