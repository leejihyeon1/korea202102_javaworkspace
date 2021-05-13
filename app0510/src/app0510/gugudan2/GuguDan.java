package app0510.gugudan2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import app0510.event.keyControl;

public class GuguDan extends JFrame{
	JTextField t_input;
	JButton bt;
	JLabel la;
	
	public GuguDan() {
		la=new JLabel("몇단?");
		t_input=new JTextField(10);
		bt=new JButton("출력");
		t_input.addKeyListener(new KeyControl());
		bt.addActionListener(new ActionControl());
		
		setLayout(new FlowLayout());
		
		add(la);
		add(t_input);
		add(bt);
		
		setVisible(true);
		setSize(200, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new GuguDan();
	}
	
}
