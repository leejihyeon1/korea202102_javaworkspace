package app0512.graphic;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

//JPanel을 상속받아서, paint메서드를 재정의 하기 위한 클래스
public class DetailView extends JPanel{
	PhotoAlbum photoAlbum;
	Image image;
	
	public DetailView(PhotoAlbum photoAlbum) {
		this.photoAlbum=photoAlbum;
	}
	//클릭시마다 넘겨받을 이미지처리
	public void setImage(Image image) {
		this.image = image;
		System.out.println("클릭시 넘어온 이미지는"+image);
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, this);
	}
	

}
