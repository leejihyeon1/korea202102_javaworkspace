package app0513.practice;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ThumbPanel extends JPanel implements MouseListener{
	Image image;
	XPanel xPanel;
	
	public ThumbPanel(Image image,XPanel xpanel) {
		this.image=image;
		this.xPanel=xpanel;
		this.addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, 50, 50, this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		xPanel.setImage(image);
		xPanel.repaint();
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
