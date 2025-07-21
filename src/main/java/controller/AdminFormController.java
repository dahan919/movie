package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import dto.AdminDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AdminService;
import view.ModelAndView;

public class AdminFormController implements Controller {
 
	@Override 
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ModelAndView view  = new ModelAndView("admin.jsp", false);;
	
		return view;
	}

}
