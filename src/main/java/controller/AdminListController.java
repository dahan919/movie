package controller;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import view.ModelAndView;

public class AdminListController implements Controller {

	//통합 검색기능을 구현하는 controller
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView view = new ModelAndView("admin.jsp", false);;

		return view;
	}

}
