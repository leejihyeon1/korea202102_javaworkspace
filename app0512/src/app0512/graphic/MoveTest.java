package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//캔버스에 채워진 원을 하나 그리고 나서, 버튼에 의해 이 원이 x축 방향으로 이동하는 효과 부여하기!
public class MoveTest extends JFrame implements ActionListener{
	JPanel p_north;
	MyButton bt;
	MyCanvas can;//커스터마이징된 캔버스
	int x=100; //원의 x좌표
	
	public MoveTest() {
		p_north=new JPanel();
		bt=new MyButton("버튼이야");
		can=new MyCanvas(this);
		
		can.setBackground(Color.red);
		
		p_north.add(bt);
		add(p_north,BorderLayout.NORTH);
		add(can);
		
		//버튼과 리스너 연결
		bt.addActionListener(this);
		
		setBounds(1600, 100, 700, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void tick() {//물리량 변화 즉 변화되는 값
		x=x+10;
		System.out.println(x);
	}
	public void render() {
		//MyCanvas를 다시 그려달라고 요청하자!
		can.repaint();//update()-->paint()
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		tick();
		render();
	}
	public static void main(String[] args) {
		new MoveTest();
	}

}
