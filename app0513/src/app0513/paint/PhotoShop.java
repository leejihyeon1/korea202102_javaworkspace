package app0513.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoShop extends JFrame{
	JPanel p_north;
	JButton bt_eraser;
	Color[] colorArray= {Color.red,Color.orange,Color.yellow,Color.green,Color.blue,Color.gray,Color.pink};
	MyCanvas can;
	
	public PhotoShop() {
		//생성
		p_north=new JPanel();
		bt_eraser=new JButton("지우기");
		can=new MyCanvas();
		
		for(int i=0; i<colorArray.length; i++) {
			ColorBox colorBox=new ColorBox(colorArray[i]);
			p_north.add(colorBox);
		}
		//스타일
		p_north.setPreferredSize(new Dimension(700,50));
		
		//조립
		p_north.add(bt_eraser);
		add(p_north,BorderLayout.NORTH);
		add(can);
		//보여주기
		setBounds(1000,100,700,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new PhotoShop();
	}

}