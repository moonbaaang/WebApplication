package tv;

import org.xml.sax.SAXNotRecognizedException;

public class TVMain {

	// tv ��ü�� �����ϴ� ���� ���� �ڵ尡 ������� ��� - coupling�� ����
	// Ŀ�ø��� ���� �ڵ尡 �ʿ��� ���� / ���� �ڵ尡 �ʿ��� ���� �ִ�.
	// �������̽� - �޼ҵ� ���� - ��� ����Ŭ������ ǥ��ȭ �޼ҵ� �������̵�, ���� ���� Ŭ���� Ÿ�� ȣȯ
	// ����Ƽ�� / �ＺƼ��
	public static void main(String[] args) {
		TV tv = TVFactory.getTV(args[0]); //TVFactory�� ���� - ������ �ڵ�
		
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		

	}

}
