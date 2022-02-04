package site.metacoding.ex13.enumerate;

interface Direction {
	// 인터페이스에 변수를 적으면 public static final이 생략되어 있는것임(문법)
	// static 하면 기울고, final 하면 진해짐
	String LEFT = "Left";
	String RIGHT = "Right";
}

public class EnumEx01 {

	public static void add(String direction) {
		//"Left", "Right"만 받아야 함
		if(direction.equals("Left") || direction.equals("Right")) {
			System.out.println("잘들어왔군");
		}else {
			System.out.println("너 잘못입력했어");
		}
	}
	
	public static void main(String[] args) {
		add(Direction.RIGHT);
	}

}
