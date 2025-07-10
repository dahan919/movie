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

public class FindPasswdController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//AJAX를 사용하면 ModelAndView를 미사용함
		ModelAndView view = null;
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ph_num = request.getParameter("ph_num");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("name", name);
		map.put("ph_num", ph_num);
		
		UserInfoDTO user = UserInfoService.getInstance().findPasswd(map);
		
		//비밀번호 overwrite 기능 미구현
		
		response.setContentType("application/json; charset=UTF-8");
		JSONObject obj = new JSONObject();
		
		if(user != null) {
			String tempPasswd = generateTempPasswd(10);
			user.setPasswd(tempPasswd);
			
			int n = UserInfoService.getInstance().updatePasswd(user);
			
			if(n >0) {
				obj.put("status", "success");
				obj.put("tempPasswd", tempPasswd);
			} else {
				obj.put("status", "fail");
				obj.put("message", "비밀번호 변경 실패");
			}
			
		} else {
			
			obj.put("status", "fail");
			obj.put("message", "일치하는 회원이 없습니다.");
			
		}
		
		return null;
	}

	private String generateTempPasswd(int length) {
		String chars = "L7xurIu3SpQMMqZAdx0Lb7j";
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i< length; i++) {
			int index = (int) (Math.random() * chars.length()); 
			sb.append(chars.charAt(index));
		}
		
		return sb.toString();
	}

}
