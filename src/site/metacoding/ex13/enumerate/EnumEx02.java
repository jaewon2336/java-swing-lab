package site.metacoding.ex13.enumerate;

enum Way {
	Left, Right;
}

public class EnumEx02 {

	public static void add(Way way) {
		System.out.println(way);
	}

	public static void main(String[] args) {
		// add("Right"); // 스트링 타입이라 넣을 수 없음
		add(Way.Left);
	}

}
