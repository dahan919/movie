package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dto.UserInfoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserInfoService;
import view.ModelAndView;

public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		//인터페이스 기반 프로그래밍
		//결합도 낮추기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("passwd", passwd);
		
		//isAdmin값도 같이 옴
		//isAdmin값을 login(map)에서 설정해서 가져옴
		UserInfoDTO user = UserInfoService.getInstance().login(map);
		
		if(user != null) {
			
			HttpSession session =  request.getSession();
			//3시간동안 session내부 데이터 유지
			session.setMaxInactiveInterval(60*60*3);
			
			session.setAttribute("user", user);
			session.setAttribute("loginMsg", "로그인 성공");
			
			//메인 페이지 이동
			view = new ModelAndView("main.jsp", false);
			
		} else {
			
			request.setAttribute("errorMsg", "아이디 혹은 비밀번호가 틀렸습니다.");
			
			//로그인 페이지 이동
			view = new ModelAndView("login.jsp", false);
		}
		
		return view;
	}

}
