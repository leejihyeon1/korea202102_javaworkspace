package app0510.swing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame{
	JTextArea area;
	JPanel p_south;
	JTextField t_input;
	JButton bt_send;
	
	public ChatClient() {
		//생성
		area=new JTextArea();
		p_south=new JPanel();
		t_input=new JTextField(20);
		bt_send=new JButton("전송");
		//스타일
		area.setBackground(Color.yellow);
		//조립
		add(area); //this생략중
		p_south.add(t_input);
		p_south.add(bt_send);
		add(p_south,BorderLayout.SOUTH);
		//보여주기
		this.setSize(350, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);//윈도우 닫을 때 프로세스도 종료됨!
	}
	
	public static void main(String[] args) {
		new ChatClient();
	}

}
