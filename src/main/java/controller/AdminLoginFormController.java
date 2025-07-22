package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

public class AdminLoginFormController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = null;
		
<<<<<<< HEAD
		view = new ModelAndView("admin_login.jsp", false);
=======
		view = new ModelAndView("admin_login.jsp", true);
>>>>>>> main
		
		return view;
	}

}
