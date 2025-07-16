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

public class HeaderController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView view = null;
		
		HttpSession session = request.getSession(false);
		
		if (session != null) {
		
			String id = (String) session.getAttribute("id");
			//비밀번호는 보안상 삭제할까 고민중
			String passwd = (String) session.getAttribute("passwd"); 
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", id);
			//비밀번호는 보안상 삭제할까 고민중
			map.put("passwd", passwd);
			
			if(id != null && passwd != null) {
				
				UserInfoDTO dto = UserInfoService.getInstance().selectNicknmById(map);
				
				String nickNm = dto.getNickNm();
				
			} else {
				
				//세션이 만료될 시 출력; 세션은 3시간으로 설정해놨음
				request.setAttribute("msg", "세션이 만료되어 유저의 정보가 존재하지 않습니다.");
				
			}
			
		} else {
		
			//세션이 만료될 시 출력; 세션은 3시간으로 설정해놨음
			request.setAttribute("msg", "세션이 만료되었습니다.");
			
		}
		
		view = new ModelAndView("header.jsp", false);
		
		return view;
	}

}
