package view;

public class ModelAndView {
	//Model and View class
	//Role: View (MVC structure)
	//Handles layout and display
	//레이아웃과 화면을 처리하는 클래스
	//앱의 데이터를 보여주는 방식을 정의합니다.
	
	//1.Field
	//1-1. 경로
	//앞단의 jsp,html에서 보내주는 경로를 이용
	private String path;
	//1-2. 이동의 방법을 정의: redirect / forward
	//True: redirect
		//client에게 새롭게 요청을 해줄 것을 요구
		//URL 바뀜
		//기존 Request/Response 객체 소멸, 새 객체 생성
		//속도 느림
	
	//False: forward
		//Server 내부에서의 이동
		//URL은 바뀌지 않음
		//Request/Response 객체 역시 유지됨
		//속도 빠름
	
	//Controller에서 isRedirect와 
	//getRequestDispatcher().forward를 사용해서 이동방법을 정의해줄 예정
	private boolean redirect;
	
	//2. Constructor
	//필드를 이용한 생성자
	
	//필드를 이용하지 않은 생성자가 없으므로
	//이제 ModelAndView를 사용하는 모든 메소드나 클래스는 
	//반드시 경로와 이동의 방법을 정의해주어야만 함
	public ModelAndView(String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}

	//3.Getter,Setter
	
	//3-1.경로 getter
	public String getPath() {
		return path;
	}

	//3-2.경로 setter
	public void setPath(String path) {
		this.path = path;
	}

	//3-3.redirect getter
	public boolean isRedirect() {
		return redirect;
	}

	//3-4.redirect setter
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	@Override
	public String toString() {
		return "ModelAndView [path=" + path + ", redirect=" + redirect + "]";
	}
	
}
