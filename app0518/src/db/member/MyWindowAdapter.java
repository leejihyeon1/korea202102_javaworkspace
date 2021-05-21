package db.member;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 자바에서는 이벤트 리스너의 메서드가 3개이상 될때는, 개발자 대신 메서드 재정의 의무를 짊어진 어댑터 클래스를 지원한다
//그리고 어댑터 클래스의 예) keylistener -->keyadapter, windowlistener-->windowadapter, mouselistener-->mouseadapter
public class MyWindowAdapter implements WindowListener{
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}
}
