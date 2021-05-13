package app0510.event;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class EventTest extends JFrame{
	JTextField t_input;
	JButton bt;
	
	public EventTest() {
		t_input=new JTextField(20);
		bt=new JButton("눌러");
		
		//flowlayout으로 전환
		this.setLayout(new FlowLayout());
		
		//조립
		add(t_input);
		add(bt);
		
		//컴포넌트와 리스너와의 연결!
		//actioncontrol is a actionlistener이니깐
		//아래의 메서드의 매개변수엔 actioncontrol의 인스턴스를 넘기면 된다
		bt.addActionListener(new ActionControl());
		
		//텍스트필드와 키리스너와의 연결
		t_input.addKeyListener(new keyControl());
		
		//프레임본체를 대상으로 마우스리스너와 연결
		this.addMouseListener(new MouseControl());
		
		//프레임본체를 대상으로 윈도우리스너와 연결
		this.addWindowListener(new WindowControl());
		
		//보여주기
		setSize(250, 150);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new EventTest();
	}
}
