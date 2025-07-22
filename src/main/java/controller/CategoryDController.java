package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.DramaDTO;
import dto.MediaDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.DramaService;
import service.MediaService;
import view.ModelAndView;

public class CategoryDController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
				
				ModelAndView view = null;
				
				//+alpha) api값 받아오기
				String apiResult = DramaService.getInstance().search(null);
				
				List<DramaDTO> dList = DramaService.getInstance().StringToJSON(apiResult);
				
				JSONArray apiArray = new JSONArray(dList);
				
				String name = request.getParameter("name");
				
				//1.DB에서 데이터 꺼내오기
				List<DramaDTO> dramaList = DramaService.getInstance().selectByName(name);
				
				//2.꺼낸 데이터 JSON으로 변환
				JSONArray array = new JSONArray(dramaList);
				
				//3. JSONObject에 배열 두개 넣어서 보내주기
				JSONObject obj = new JSONObject();
				obj.put("apiArray", apiArray);
				obj.put("array", array);
				
				//4. 데이터 AJAX로 페이지로 보내주기
				// 시간이 없어서 api 데이터를 받를 페이지가 없다면 obj말고 array만 받을 것
				response.setContentType("application/json; charset=UTF-8");
				response.getWriter().print(obj.toString());
				
				return view;


	}

}
