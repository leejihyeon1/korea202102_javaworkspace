package app0510.event;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuguDan extends JFrame{
	JTextField t_input;
	JButton bt;
	JLabel la;
	
	public GuguDan() {
		//생성
		la=new JLabel("원하시는 단 입력");
		t_input=new JTextField(15);
		bt=new JButton("출력");
		
		//조립
		this.setLayout(new FlowLayout());
		this.add(la);
		this.add(t_input);
		this.add(bt);
		
		//버튼에 이벤트 적용
		bt.addActionListener(new GugudanEvent(t_input));
		
		//보여주기
		this.setSize(250, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GuguDan();
	}
}
