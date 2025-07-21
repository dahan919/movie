package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AnnouncementService;
import view.ModelAndView;

public class WriteNoticeController implements Controller {
 
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		
		String a_title = request.getParameter("a_title");
		String a_content = request.getParameter("a_content");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a_title", a_title);
		map.put("a_content", a_content);
		 
		int n = AnnouncementService.getInstance().insertAnnouncement(map);
		
		if(n != 0) {
			request.setAttribute("map", map);
			request.setAttribute("msg", "공지가 추가되었습니다.");
		} else {
			request.setAttribute("msg", "공지추가가 실패하였습니다.");
		}
		
	
		
		return view;
	}

}
