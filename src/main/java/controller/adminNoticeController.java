package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import dto.AnnouncementDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AnnouncementService;
import view.ModelAndView;

public class adminNoticeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView view = null;
		
		String aTitle = request.getParameter("a_title");
		String aContent = request.getParameter("a_content");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aTitle", aTitle);
		map.put("aContent", aContent);
		
		int n = AnnouncementService.getInstance().insertAnnouncement(map);
		
		if(n!=0) {
			
			List<AnnouncementDTO> announcementList = AnnouncementService.getInstance().selectAll();
			
			JSONArray announcementArray = new JSONArray(announcementList);
			
			response.getWriter().println(announcementArray);
		}
		
		return view;
		
	}

}
