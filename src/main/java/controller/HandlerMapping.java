package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

public class HandlerMapping {
<<<<<<< HEAD
	//1. Singleton
	
	//HandlerMapping에 Singleton 패턴을 적용하는 이유
	
		//1. Controller mapping logic을 한 곳에서만 관리하기 위해
		//여러 객체가 controller를 따로따로 관리하게 되면 불일치, 중복, 비효율이 생김
		//* 불일치(inconsistency): 요청(command)과 Controller가 다르게 연결되는 문제
		//* 중복(Duplication): 동일한 매핑 정보를 여러 객체에 반복해서 저장하거나 정의해야 하는 문제
		//* 비효율(Inefficiency): 같은 객체를 여러번 생성하면서 메모리를 낭비하고 속도를 떨어뜨리는 행위
	
		//2. 객체를 매번 새로 만들지 않기 위해
		//객체를 매번 새로 만들고 방치하게 되면 메모리를 계속 잡아먹게 될뿐만 아니라
		//Controller 매핑 테이블을 매번 다시 생성해야 함
		//쓰던 객체를 골수까지 쓰는 게 훵씬 효율적임
	
		//3. 글로벌한 접근을 위해
		//? 이건 공부해 보겠음.rmsep 
=======
	// 1. Singleton

	// HandlerMapping에 Singleton 패턴을 적용하는 이유

	// 1. Controller mapping logic을 한 곳에서만 관리하기 위해
	// 여러 객체가 controller를 따로따로 관리하게 되면 불일치, 중복, 비효율이 생김
	// * 불일치(inconsistency): 요청(command)과 Controller가 다르게 연결되는 문제
	// * 중복(Duplication): 동일한 매핑 정보를 여러 객체에 반복해서 저장하거나 정의해야 하는 문제
	// * 비효율(Inefficiency): 같은 객체를 여러번 생성하면서 메모리를 낭비하고 속도를 떨어뜨리는 행위

	// 2. 객체를 매번 새로 만들지 않기 위해
	// 객체를 매번 새로 만들고 방치하게 되면 메모리를 계속 잡아먹게 될뿐만 아니라
	// Controller 매핑 테이블을 매번 다시 생성해야 함
	// 쓰던 객체를 골수까지 쓰는 게 훵씬 효율적임

	// 3. 글로벌한 접근을 위해
	// ? 이건 공부해 보겠음.
>>>>>>> main
	private static HandlerMapping instance = new HandlerMapping();

	public HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		if (instance == null)
			instance = new HandlerMapping();
		return instance;
	}

	// 2. 경로에서 뽑은 command를 이용해서 controller를 생성
	public Controller createController(String command) {

		Controller controller = null;

		switch (command) {

		// admin_login.jsp
		// 관리자 로그인 페이지 기능
		case "adminLogin":
			controller = new AdminLoginController();
			break;

		// -> admin_login.jsp
		// 관리자 로그인 페이지 이동 기능
		case "adminLoginForm":
			controller = new AdminLoginFormController();
			break;

		// admin.jsp
		// 관리자 페이지 기능
		case "admin":
			controller = new AdminController();
			break;

		// -> admin.jsp
		// 관리자 페이지 이동 기능
		case "adminForm":
			controller = new AdminFormController();
			break;

		// join_member.jsp
		// 회원가입 페이지 기능
		case "join":
			controller = new JoinMemberController();
			break;
			
		// -> join_member.jsp
		// 회원가입 페이지 기능
		case "joinMemberForm":
			controller = new JoinMemberFormController();
			break;

		// find_id.jsp
		// 아이디 찾기 페이지 기능
		case "findId":
			controller = new FindIdController();
			break;

		// -> find_id.jsp
		// 아이디 찾기 페이지 이동 기능
		case "findIdForm":
			controller = new FindIdFormController();
			break;

		// find_password.jsp
		// 비밀번호 찾기 페이지 기능
		case "findPasswd":
			controller = new FindPasswdController();
			break;

		// -> find_password.jsp
		// 비밀번호 찾기 페이지 이동 기능
		case "findPasswdForm":
			controller = new FindPasswdFormController();
			break;

		// login.jsp
		// 로그인 페이지 기능
		case "login":
			controller = new LoginController();
			break;

		// -> login.jsp
		// 로그인 페이지로 이동기능
		case "loginForm":
			controller = new LoginFormController();
			break;

		// comment.jsp
		// 코멘트 기능
		case "comment":
			controller = new CommentWriteController();
			break;

		// -> comment.jsp
		// 모든 코멘트 보기 페이지 이동 기능
		case "commentForm":
			controller = new CommentFormController();
			break;

		// -> notice.jsp
		// 관리자 공지쓰기페이지로 이동 기능
		case "adminNoticeForm":
			controller = new AdminNoticeFormController();
			break;

		// notice.jsp
		// 관리자 페이지에서 공지쓰기 페이지 기능
		case "adminNotice":
			controller = new adminNoticeController();
			break;

		// -> user_notice.jsp
		// 유저공지확인 페이지 이동 기능:소연씨 몫

		// user_notice.jsp
		// 유저공지 페이지 기능
		case "user_notice":
			controller = new userNoticeController();
			break;

		// detail.jsp
		// 미완
		case "detailPage":
			controller = new MainPageController();
			break;

		// -> detail.jsp
		// 상세페이지로 이동
		case "detailPageForm":
			controller = new DetailPageFormController();
			break;

		// -> header
		// header 이동 기능
		case "header":
<<<<<<< HEAD
				controller = new HeaderController();
				break;
		
		//공지 보여주기
		case "user-notice":
				controller = new UserNoticeController();
				break;
			
		case "userNoticeForm" :
			controller = new UserNoticeFormController();
				break;
				
		//영화 페이지 이동:미완
=======
			controller = new HeaderController();
			break;

		// -> category_media.jsp
		// 영화 페이지 이동
>>>>>>> main
		case "categoryMForm":
			controller = new CategoryMFormController();
			break;

		// -> category_drama.jsp
		// 드라마 페이지 이동
		case "categoryDForm":
			controller = new CategoryDFormController();
			break;

		// -> category_webtoon.jsp
		// 웹툰 페이지 이동
		case "categoryWForm":
			controller = new CategoryWFormController();
			break;

		// category_media.jsp
		// 영화 페이지 기능
		case "categoryM":
			controller = new CategoryMController();
			break;

		// category_drama.jsp
		// 드라마 페이지 기능
		case "categoryD":
			controller = new CategoryDController();
			break;

		// category_webtoon.jsp
		// 웹툰 페이지 기능
		case "categoryW":
			controller = new CategoryWController();
			break;

		// detail.jsp
		// 메인페이지에서 이미지 클릭시 해당 영화에 해당하는 상세페이지로 이동기능
		case "detailForm":
			controller = new DetailFormController();
			break;

		// detail.jsp
		// 상세페이지에서 이미지에 해당하는 정보 출력기능: 미완
		case "detail":
			controller = new DetailController();
			break;
		}

		return controller;
	}

}
