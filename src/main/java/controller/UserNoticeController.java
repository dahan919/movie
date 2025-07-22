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
<<<<<<< HEAD:src/main/java/controller/UserNoticeController.java
		
		ModelAndView view = null;  
=======

		ModelAndView view = null;
>>>>>>> main:src/main/java/controller/userNoticeController.java
		
		List<AnnouncementDTO> announcementList = AnnouncementService.getInstance().selectAll();
		
		JSONArray announcementArray = new JSONArray(announcementList);
		
<<<<<<< HEAD:src/main/java/controller/UserNoticeController.java
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(array.toString());
=======
		response.getWriter().println(announcementArray.toString());;
>>>>>>> main:src/main/java/controller/userNoticeController.java
		
		return null;
		
	}

}
