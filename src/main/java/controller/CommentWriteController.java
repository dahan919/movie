package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.CommentaryDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CommentaryService;
import view.ModelAndView;

public class CommentWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		
		double score_c = Double.parseDouble(request.getParameter("score_c"));
		String criticism = request.getParameter("criticism");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("score_c", score_c);
		map.put("criticism", criticism);
		
		//DTO는 하나의 객체임
		List<CommentaryDTO> list = CommentaryService.getInstance().select3(map);
		
		//AJAX로 출력
		
		//출력할 JSONArray 객체를 만듬
		JSONArray arr = new JSONArray();
		//받아온 list 객체에 데이터를 뽑아서 
		//JSONObject에 넣은 후 
		//JSONArray에 넣기
		list.forEach(dto -> {
			JSONObject obj = new JSONObject();
			obj.put("c_num", dto.getC_num());
			obj.put("criticism", dto.getCriticism());
			obj.put("score_c", dto.getScore_c());
			obj.put("writedate", dto.getWritedate());
			arr.put(obj);
		});
		
		//백단과 앞단이 데이터를 주고받을 때
		//주고받는 데이터는 결국 String, 문자열임.
		//JSONArray를 String값으로 변환해서 보내줄 것
		response.getWriter().println(arr.toString());
		
		return view;
	}

}
