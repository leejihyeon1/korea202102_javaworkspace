package app0513.paint;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyCanvas extends Canvas implements MouseListener,MouseMotionListener{
	boolean flag=false;
	
	public MyCanvas() {
		setBackground(Color.white);
		
		//리스너와 연결
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	@Override
	public void paint(Graphics g) {
		if(flag) {
			g.fillOval(100, 100, 2, 2);//채워진 원 즉 점을 그린다!
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		flag=true;
		repaint();
	}

	@Override
	//이때부터 그림그리기 가능
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	//그림 그리기 불가
	public void mouseReleased(MouseEvent e) {
		flag=false;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
