package app0513.album;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

//썸네일의 이미지를 그리기 위한 썸네일 패널
public class ThumbPanel extends JPanel implements MouseListener{
	Toolkit kit;
	Image image;
	int width=50;//유지보수성을 높이기 위해 변수로 지정
	int height=50;
	XCanvas can;//null, has a 관계
	
	public ThumbPanel(String filename,XCanvas can) {
		this.setPreferredSize(new Dimension(width,height));
		kit=Toolkit.getDefaultToolkit();//new 할수없다!
		image=kit.getImage(filename);
		this.can=can;//넘겨받은 캔버스 주소값을 멤버변수로 보관해놓자!
		//image=image.getScaledInstance(50, 50, image.SCALE_SMOOTH);
		this.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0,width,height,this);//x,y,width,height,observer
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("xcanvas에 전달할 이미지는"+image);
		can.setImage(image);
		can.repaint();//캔버스 다시 그리기 요청!
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
