package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

public class AdminNoticeFormController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
			ModelAndView view = null;
			
			//관리자 공지 페이지
			view = new ModelAndView("notice.jsp", true);
			
			return view;
		
	}

}
