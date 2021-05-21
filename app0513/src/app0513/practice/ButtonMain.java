package app0513.practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonMain extends JFrame implements ActionListener{
	JPanel p_north;
	JPanel p_center;
	JTextField t_input;
	JButton bt_create;
	JButton bt_createOne;
	JButton bt_bg;
	Color color=Color.red;
	int count=0;
	JButton[] ar;
	ArrayList<JButton> btAr=new ArrayList<JButton>();
	
	public ButtonMain() {
		//생성
		p_north=new JPanel();
		p_center=new JPanel();
		t_input=new JTextField(10);
		bt_create=new JButton("일괄생성");
		bt_createOne=new JButton("하나생성");
		bt_bg=new JButton("배경색");
		
		bt_create.addActionListener(this);
		bt_createOne.addActionListener(this);
		bt_bg.addActionListener(this);
		//스타일
		p_north.setPreferredSize(new Dimension(500,50));
		p_center.setBackground(color.yellow);
		//조립
		p_north.add(t_input);
		p_north.add(bt_create);
		p_north.add(bt_createOne);
		p_north.add(bt_bg);
		
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		//보여주기
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,500,600);
	}
	public void createBt() {
		int num=Integer.parseInt(t_input.getText());
		ar=new JButton[num];
		for(int i=0; i<num; i++) {
			JButton bt=new JButton("버튼"+i);
			ar[i]=bt;
			p_center.add(bt);
		}
	}
	public void createBtOne() {
		JButton bt=new JButton("버튼"+count++);
		btAr.add(bt);
		p_center.add(bt);
	}
	public void setColor() {
		if(ar!=null) {
			for(int i=0; i<ar.length; i++) {
				ar[i].setBackground(color);
			}		
		}
		if(btAr!=null) {
			for(int i=0; i<btAr.size(); i++) {
				btAr.get(i).setBackground(color);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt_create) {
			createBt();
		}else {
			if(e.getSource()==bt_createOne) {
				createBtOne();
			}else if(e.getSource()==bt_bg) {
				setColor();
			}
		}
			p_center.updateUI();//paint 없을 때는 updateui!!!!!!!!!!!!
		}
		
	public static void main(String[] args) {
		new ButtonMain();
	}

}
