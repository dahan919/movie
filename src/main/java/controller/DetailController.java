package controller;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;

import dto.MediaDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.MediaService;
import view.ModelAndView;

public class DetailController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String value = request.getParameter("value");
		
		List<MediaDTO> mediaList = MediaService.getInstance().selectByValue(value);
		
		JSONArray mediaArray = new JSONArray(mediaList);
		
		response.getWriter().println(mediaArray);
		
		return null;
	}

}
