package site.metacoding.practice;

/**
 * 
 * @author 정재원 --- 생성자 실행순서-------------- initObject 1번 실행 initSetting 2번 실행
 *         initListener 3번 실행 (default)
 *
 */

public interface Init {
	void initObject();

	void initSetting();

	// 새로나온 문법
	// 인터페이스에서 몸체가 있는 메서드를 만들 수 있음
	// 강제성이 사라짐
	default void initListener() {
	};
}
