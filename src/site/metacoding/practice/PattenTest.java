package site.metacoding.practice;

// ����� ����

interface knife {
	void attack();

	void cook();
}

// �������� ���� �������̽��� �ٲ� �� ��� ����� ������ ����
// ������ �������̽��� default ������ ���Ա� ������ �� ������� ����
// default�� ������ �޼��� ������ ���������� �������� �����

abstract class �丮������ implements knife {
	// �߻� �޼��带 ���� �� �ֱ� ������ �������̽� �������� �ʾƵ� ����

	@Override
	public void attack() {
	} // attack �޼��带 �����ؼ� �ɷ�����
}

abstract class �ο�۾���� implements knife {
	@Override
	public void cook() {
	} // cook �޼��带 �����ؼ� �ɷ�����
}

class ������ extends �丮������ {

	@Override
	public void cook() {

	}

}

class ������ extends �ο�۾���� {

	@Override
	public void attack() {

	}

}

public class PattenTest {

}
