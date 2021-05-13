package app0510.event;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//JVM이 keyevent객체를 생성하면, 아래의 리스너에게 이벤트 객체를 전달하므로,
//개발자는 키보드와 관련된 원하는 작업을 아래의 클래스에서 완성지으면 된다

//아래의 keycontrol 클래스는 keylistener의 자식이므로, 키와 관련된 모든 이벤트를 청취할수있다
public class keyControl implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped 호출");
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed 호출");
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased 호출");
	}

}
