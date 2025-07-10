package controller;

public class HandlerMapping {
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
		//? 이건 공부해 보겠음.
	private static HandlerMapping instance = new HandlerMapping();

	public HandlerMapping() {}
	
	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		return instance;
	}
	
	//2. 경로에서 뽑은 command를 이용해서 controller를 생성 
	public Controller createController(String command) {
		
		Controller controller = null;
		
		switch(command) {
		case "login" :
				controller = new LoginController();
				break;
		
		case "admin":
				controller = new AdminLoginController();
				break;
				
		case "join":
				controller = new JoinMemberController();
				break;
				
		case "findId":
				controller = new FindIdController();
				break;
				
		case "findPasswd":
				controller = new FindPasswdController();
				break;
		
		}
		
		return controller;
	}

}
