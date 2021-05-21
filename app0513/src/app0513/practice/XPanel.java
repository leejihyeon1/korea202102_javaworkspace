package app0513.practice;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class XPanel extends Canvas{
	Toolkit kit;
	Image image;
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, 500, 400, this);
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
}
