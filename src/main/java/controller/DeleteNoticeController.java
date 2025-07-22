package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AnnouncementService;
import view.ModelAndView;

public class DeleteNoticeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		
		String a_num = request.getParameter("a_num");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a_num", a_num);

	
		String n = AnnouncementService.getInstance().deleteAnnouncement(map);
		
		if (n != null && !n.equals("")) {
			request.setAttribute("map", map);
			request.setAttribute("msg", "공지가 추가되었습니다.");
		} else {
			request.setAttribute("msg", "공지추가가 실패하였습니다.");
		}
		
	
		return view;
	}

}
