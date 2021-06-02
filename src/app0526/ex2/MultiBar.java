package app0526.ex2;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MultiBar extends JFrame{
	Thread t1;
	Thread t2;
	Thread t3;
	
	BarThread b1;
	BarThread b2;
	BarThread b3;
	JButton bt;
	
	public MultiBar() {
		b1=new BarThread(1);
		b2=new BarThread(3);
		b3=new BarThread(5);
		Dimension d=new Dimension(275,35);
		bt=new JButton("go");
		
		setLayout(new FlowLayout());
		b1.setPreferredSize(d);
		b2.setPreferredSize(d);
		b3.setPreferredSize(d);
		
		add(b1);
		add(b2);
		add(b3);
		add(bt);
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				t1=new Thread(b1);//러너블과 쓰레드 연결		
				t2=new Thread(b2);		
				t3=new Thread(b3);	
				
				//이 시점부터 개발자가 start() 메서드를 호출하면 해당 쓰레드의 run() 메서드 호출은
				//runnable 인터페이스를 구현한 객체의 것을 호출한다
				t1.start();
				t2.start();
				t3.start();
			}
		});
		
		setVisible(true);
		setBounds(500,500,300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MultiBar();
	}

}
