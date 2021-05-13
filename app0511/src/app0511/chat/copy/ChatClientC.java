package app0511.chat.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientC extends JFrame implements KeyListener{
	JTextArea area;
	private JTextArea area2;//chatClientA가 보유한 area
//	private JTextArea area3;//chatClientB가 보유한 area
	JScrollPane scroll;
	JTextField t_input;
	ChatClientB cb;
	
	
	public ChatClientC() {
		//생성
		area=new JTextArea();
		scroll=new JScrollPane(area);
		t_input=new JTextField(24);
		//스타일,레이아웃
		setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280,280));
		area.setBackground(Color.pink);
		//조립
		add(scroll);
		add(t_input);
		
		//이벤트연결
		t_input.addKeyListener(this);
		//보여주기
		setVisible(true);
		setBounds(950,100,300,400);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			showText();
		}
		
	}
	public void setCb(ChatClientB cb) {
		this.cb=cb;
	}
	public void setArea2(JTextArea area) {//setter
		area2=area;
	}
//	public void setArea3(JTextArea area) {//setter
//		area3=area;
//	}
	public void showText() {
		//나의 텍스트 필트 값 구하기
		String msg=t_input.getText();
		//나의 textarea에 누적
		area.append(msg+"\n");
		//chatA의 textarea에 누적
		area2.append(msg+"\n");
		//chatB의 textarea에 누적
		cb.area.append(msg+"\n");
		//입력값 초기화
		t_input.setText("");
	}
	

}
