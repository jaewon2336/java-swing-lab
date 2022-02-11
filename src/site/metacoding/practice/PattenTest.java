package site.metacoding.practice;

// 어댑터 패턴

interface knife {
	void attack();

	void cook();
}

// 백종원을 위해 인터페이스를 바꿀 수 없어서 어댑터 패턴이 나옴
// 하지만 인터페이스에 default 문법이 나왔기 때문에 잘 사용하지 않음
// default가 붙으면 메서드 구현이 가능해져서 강제성이 사라짐

abstract class 요리사어댑터 implements knife {
	// 추상 메서드를 가질 수 있기 때문에 인터페이스 구현하지 않아도 가능

	@Override
	public void attack() {
	} // attack 메서드를 구현해서 걸러내기
}

abstract class 싸움꾼어댑터 implements knife {
	@Override
	public void cook() {
	} // cook 메서드를 구현해서 걸러내기
}

class 백종원 extends 요리사어댑터 {

	@Override
	public void cook() {

	}

}

class 검투사 extends 싸움꾼어댑터 {

	@Override
	public void attack() {

	}

}

public class PattenTest {

}
