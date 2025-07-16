package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dto.UserInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserInfoService;
import view.ModelAndView;

public class JoinMemberController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView view= null;
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String nickNm = request.getParameter("nickNm");
		String ph_num = request.getParameter("ph_num");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("passwd", passwd);
		map.put("name", name);
		map.put("nickNm", nickNm);
		map.put("ph_num", ph_num);
		
		int n = UserInfoService.getInstance().insertMember(map);
		
		if(n != 0) {
			
			view = new ModelAndView("login.jsp", false);
			
		} else {
			
			view = new ModelAndView("join_member.jsp", false);
			
		}
		
		return view;
	}

}
