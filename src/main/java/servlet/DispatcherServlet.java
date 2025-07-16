package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

import java.io.IOException;

import controller.Controller;
import controller.HandlerMapping;

//Servlet은 TOMCAT과 같은 Servlet Container가 있어야만 사용할 수 있음.

//1.모든 앞단에서 보내는 데이터를 받아서 처리
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String rootPath = "/WEB-INF/views/";
       
    public DispatcherServlet() {
    }

    //앞단에서 form이나 a href를 사용해 request에 데이터를 넣어서 보내줄 때,
    //variable의 이름을 설정하는 방법은 여러가지가 있는데 개 중 두가지를 소개함
    
    //1. input에 name속성과 value속성을 넣기
    //<input name="a" value="b">
    //다음과 같이 설정하면 변수이름은 a가, 변수에 들어가는 초기값은 b가 됨.
    //즉 변수 초기화를 할 수 있음.
    
    //2. fetch("...?a=")
    //다음과 같이 설정하면 변수이름은 a가 됨
    //단, 값 초기화는 안되어 있으므로 input에 반드시 값을 넣어줄 것
    
    //DispatcherServlet이 doGet 메소드만 쓰는 이유
    
    	//Servlet의 코드를 보면 의아한 점이 있음.
    	//바로 메소드는 doGet과 doPost 두개가 있는데
    	//정작 doPost는 doGet을 단순히 호출하는 형태이기 때문에
    	//사실상 doGet만 쓰는 형태라는 거임.
    	//이러는 이유는 다음과 같음.
    
    	//1. GET과 POST를 같은 로직으로 처리하기 위해서
    	//DispatcherServlet은 단순히 요청을 받아서 Controller에 넘기는 전달자 역할만 함.
    	//DispatcherServlet은 기존의 Servlet들과 다르게 그저 Controller를 구현해서 선택하는 역할만 하는 거임
    	//즉, GET으로 보내냐 POST로 보내냐 같은 전송방식을 결정하는 건 
    	//데이터를 전달하고 경로를 정해주는 Controller이지 DispatcherServlet이 아니기 때문에
    	//상관안하고 doGet만 쓰는 거임
    
    	//2. 서버 라우팅 단순화
    	//client(앞단)에서 들어온 요청을 보고(url) 서버가 어느 코드(기능)를 처리할지 결정하는 과정을 
    	//Server Rounting이라고 함
    	
    	//기능은 메소드로 자바에서 구현되므로 사실상 경로를 보고 어떤 메소드를 선택할지
    	//결정하는 과정이라고 할 수 있음.
    	//하지만 dispatcherServlet은 *,wildcard로 모든 요청을 받고 있음
    
    	//따라서 그냥 하나의 메소드로 모든 경로에 맞는 controller를 찾아주는 식으로
    	//라우팅을 단순화 시키는 거임
    
    	//3. 핵심 비즈니스 로직은 Controller에서 처리하기 때문에
    	//DispatcherServlet은 그저 전달자임.
    	//전달방식은 Controller가 결정할 뿐, DispatcherServlet은 알빠노임.
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.경로받기
		//다음과 같은 경로를 받았을때
		//http://localhost:8080/StudentProject/join.do
			//1-1.getRequestURL()
			//결과: http://localhost:8080/StudentProject/join.do
			//1-2.getContextPath()
			//결과: /StudentProject
			//1-3.getServletPath()
			//결과: /join.do
		System.out.println("클래스패스 경로: " + getClass().getClassLoader().getResource("").getPath());
		
		System.out.println("DispatcherServlet called with URI: " + request.getRequestURI());
		
		//1-1. .lastIndexOf("/"): /가 마지막으로 존재한 위치의 인덱스번호를 반환
		int n = request.getRequestURI().lastIndexOf("/");
		//1-2. .substring(n+1): n+1에 해당하는 인덱스 번호부터 끝까지 잘라내기
		//1-3. .replace(".do",""): .do에 해당하는 문자열을 빈칸으로 대체함
		String command = request.getRequestURI().substring(n+1).replace(".do", "");
		
		//2. Controller 생성
		Controller controller = HandlerMapping.getInstance().createController(command);
		
		//3. ModelAndView 객체 생성
		ModelAndView view = null;
		//controller가 비어있지 않다면 controller의 execute 메소드 실행
		//사실상 execute에 실행코드가 담겨있으므로 controller의 흐름제어를 실행해준다고 할 수 있음
		if (controller != null)
			view = controller.execute(request,response);
		
		//4. 페이지이동
		//controller가 흐름제어를 했을때만 실행
		//isRedirect가 true를 리턴하면 redirect로,
		//isRedirect가 false를 리턴하면 forwarding으로 데이터를 보내줌
		if(view != null) {
			if(view.isRedirect()) {
				response.sendRedirect(request.getContextPath() + view.getPath());
			} else {
				request.getRequestDispatcher(rootPath + view.getPath()).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
