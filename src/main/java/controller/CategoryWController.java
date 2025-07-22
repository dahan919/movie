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
		
		//+alpha) api값 받아오기
		String apiResult = WebtoonService.getInstance().search(null);
		
		List<WebtoonDTO> wList = WebtoonService.getInstance().StringToJSON(apiResult);
		
		JSONArray apiArray = new JSONArray(wList);
		
		String titleName = request.getParameter("titleName");
		
		//1.DB에서 데이터 꺼내오기
		List<WebtoonDTO> webtoonList = WebtoonService.getInstance().selectByTitleName(titleName);
		
		//2.꺼낸 데이터 JSON으로 변환
		JSONArray array = new JSONArray(webtoonList);
		
		//3. JSONObject를 만들어서 배열 2개 넣기
		JSONObject obj = new JSONObject();
		obj.put("apiArray", apiArray);
		obj.put("array", array);
		
		//4. 데이터 AJAX로 페이지로 보내주기
		response.getWriter().print(obj.toString());
		
		return view;
		
	}

}
