package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.AnnouncementDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AnnouncementService;
import view.ModelAndView;

public class UserNoticeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView view = null;  
		
		List<AnnouncementDTO> announcementList = AnnouncementService.getInstance().selectAll();
		
		JSONArray array = new JSONArray();
		announcementList.forEach(item -> {
			JSONObject obj = new JSONObject();
			obj.put("a_title", item.getA_title());
			obj.put("a_content", item.getA_content());
			obj.put("a_date", item.getA_date());
			array.put(obj);
		});
		
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(array.toString());
		
		return view;
		
	}

}
