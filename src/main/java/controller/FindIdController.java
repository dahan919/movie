package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import dto.UserInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserInfoService;
import view.ModelAndView;

public class FindIdController implements Controller {
	//AJAX 사용, ModelAndView 미사용
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		ModelAndView view = null;
		
		String name = request.getParameter("name");
		String ph_num = request.getParameter("ph_num");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("ph_num", ph_num);
		
		UserInfoDTO user = UserInfoService.getInstance().findID(map);
		
		System.out.println(user);
		
		response.setContentType("application/json; charset=UTF-8");
		JSONObject obj = new JSONObject();
		
		if(user != null) {
			obj.put("status", "success");
			obj.put("id", user.getId());
		} else {
			obj.put("status", "fail");
			obj.put("message", "일치하는 회원이 없습니다.");
		}
		
		System.out.println(obj);
		
		response.getWriter().println(obj);
		
		return null;
	}

}
