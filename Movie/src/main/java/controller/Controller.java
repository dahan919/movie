package controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import view.ModelAndView;

public interface Controller {
	//비즈니스 로직을 실행하는 메서드
	//ModelAndView 객체를 사용해서 경로와 전송방법을 정의받음
	public ModelAndView execute(
			HttpServletRequest request, HttpServletResponse response)
			throws IOException;	
	//Request: client측의 데이터를 접근 시 사용(form 데이터, Parameter)
	//Response: client에게 응답을 보낼때 사용
	//throws: 이 메소드 안에서 뒤에 오는 예외사항이 발생할 수 있음을 선언
	//IOException: 입출력 예외
	
	//실행코드를 인터페이스에 두지 않는 이유
	
	//1. 결합도(coupling)을 낮추기 위해
	//공학적으로 coupling이란 두 개이상의 항이 강한 연관관계를 맺고 수식적으로 얽혀있는 형태임.
	//자바에서도 두 클래스가 코드와 로직으로 강하게 얽혀있을시 coupled, 결합되어있다고 함.
	//coupling이 된 클래스들은 코드 재사용 능력을 매우 떨어뜨리므로 기피됨
	
	//따라서 인터페이스는 메소드를 선언하여 행동의 명세, 무엇을 할 수 있을지만 약속할 뿐
	//행동의 구현, 어떻게 할 것인지 구현은 하지 않아야 결합도를 낮게 유지할 수가 있음
	
	//2. 다형성(Polymorphism)을 활용하기 위해
	//자바의 클래스에는 다중 상속 기능이 없어 다양한 구현체를 활용하지 못했고,
	//따라서 인터페이스를 만들어 다중 상속 기능을 유사하게 구현하고자 했음.
	
	//이와 같이 하나의 인터페이스로 여러 구현체를 만들수 있는 유연함이
	//인터페이스의 장점인데 실행코드를 넣으면 이러한 유연함이 없어짐
	
	//요약: 유연한 설계를 위해서
	//와닿는 방법: 한번 인터페이스 없이 구현을 servlet으로만 무식하게 해볼 것.
}
