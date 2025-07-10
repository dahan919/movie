package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dto.AdminDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AdminService;
import view.ModelAndView;

public class AdminLoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView view = null;
		//1. 데이터 받아주기
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("passwd", passwd);
		
		AdminDTO admin = AdminService.getInstance().adminCheck(map);
		
		if(admin != null) {
			
			request.getSession().setAttribute("admin", admin);
			
			//관리자 페이지 이동
			view = new ModelAndView("admin.jsp", true);
			
		} else {
			
			//관리자 로그인 페이지 이동
			view = new ModelAndView("admin_login.jsp", false);
		}
		
		return view;
	}

}
