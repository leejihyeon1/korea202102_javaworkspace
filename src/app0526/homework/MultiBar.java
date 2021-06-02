package app0526.homework;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class MultiBar extends JFrame{
	
	JProgressBar b1;
	JProgressBar b2;
	JProgressBar b3;
	JButton bt;
	
	
	public MultiBar() {
		b1=new JProgressBar();
		b2=new JProgressBar();
		b3=new JProgressBar();
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
				startBar();			
			}
		});
		
		setVisible(true);
		setBounds(500,500,300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void startBar() {
		MyThread m1=new MyThread(b1,1);
		MyThread m2=new MyThread(b2,3);
		MyThread m3=new MyThread(b3,5);
	
		m1.start();
		m2.start();
		m3.start();
	
	}
	public static void main(String[] args) {
		new MultiBar();
	}

}
