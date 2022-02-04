package site.metacoding.ex13.enumerate;

interface Direction {
	// �������̽��� ������ ������ public static final�� �����Ǿ� �ִ°���(����)
	// static �ϸ� ����, final �ϸ� ������
	String LEFT = "Left";
	String RIGHT = "Right";
}

public class EnumEx01 {

	public static void add(String direction) {
		//"Left", "Right"�� �޾ƾ� ��
		if(direction.equals("Left") || direction.equals("Right")) {
			System.out.println("�ߵ��Ա�");
		}else {
			System.out.println("�� �߸��Է��߾�");
		}
	}
	
	public static void main(String[] args) {
		add(Direction.RIGHT);
	}

}
