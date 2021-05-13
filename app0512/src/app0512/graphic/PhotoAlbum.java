package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoAlbum extends JFrame{
	JPanel p_north;//썸네일 올려놓을 패널
	JPanel canvas;//그림이 그려질 패널
	Thumbnail[] list=new Thumbnail[8];
	DetailView detailView;//상세보기 패널
	
	//썸네일 생성 메서드
	public void createThumb() {
		for(int i=0; i<list.length; i++) {
			list[i]=new Thumbnail(this);
			p_north.add(list[i]);
		}
	}
	
	public PhotoAlbum() {
		p_north=new JPanel();
		detailView=new DetailView(this);
		
		p_north.setPreferredSize(new Dimension(900,100));
		p_north.setBackground(Color.gray);
		
		add(p_north,BorderLayout.NORTH);
		createThumb();
		add(detailView);
		
		setBounds(160, 50, 900, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new PhotoAlbum();
	}

}
