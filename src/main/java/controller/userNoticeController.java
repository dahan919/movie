package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;

import dto.AnnouncementDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AnnouncementService;
import view.ModelAndView;

public class userNoticeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ModelAndView view = null;
		
		List<AnnouncementDTO> announcementList = AnnouncementService.getInstance().selectAll();
		
		JSONArray announcementArray = new JSONArray(announcementList);
		
		response.getWriter().println(announcementArray.toString());;
		
		return null;
		
	}

}
