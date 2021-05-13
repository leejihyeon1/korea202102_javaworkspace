package app0511.chat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientA extends JFrame{
	JButton bt_open;//대화 상대방을 띄우기 위한 버튼
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	
	public ChatClientA() {
		//생성
		bt_open=new JButton("열기");
		area=new JTextArea();
		scroll=new JScrollPane(area);
		t_input=new JTextField(20);
		bt=new JButton("전송");
		
		//스타일,레이아웃
		this.setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280,280));
		area.setBackground(new Color(250,255,0));
		
		//조립
		this.add(bt_open);
		this.add(scroll);//area를 scroll이 잡아먹기 때문에 scroll만 부착해도 됨!
		this.add(t_input);
		this.add(bt);
		
		//이벤트 리스너와의 연결
		//특히 이벤트리스너가 연결된 컴포넌트를 가리켜 이벤트 소스라 한다!
		ClientAEvent ce=null;//지역변수는 자옫응로 초기화되지 않으므로, 개발자가 반드시 초기화하는 습관을 가져야함
		bt.addActionListener(ce=new ClientAEvent());
		bt_open.addActionListener(ce);
		t_input.addKeyListener(ce);
		
		//ce에 t_input 전달하기
		ce.setT_input(t_input);//call by reference
		ce.setArea(area);
		ce.setBt(bt);
		ce.setBt_open(bt_open);
		
		//보여주기
		this.setBounds(300, 100, 350, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ChatClientA();
	}
	
}
