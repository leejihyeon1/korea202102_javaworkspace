package app0510.gugudan;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Gugudan extends JFrame{
	JTextField t_input;
	JButton bt;
	JLabel la;
	
	public Gugudan() {
		//생성
		la=new JLabel("몇단을 출력할까요?");
		t_input=new JTextField(10);
		bt=new JButton("출력");
		bt.addActionListener(new ActionControl(t_input));
		//스타일
		setLayout(new FlowLayout());
		//조립
		add(la);
		add(t_input);
		add(bt);
		//보여주기
		setSize(300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Gugudan();
	}
}
