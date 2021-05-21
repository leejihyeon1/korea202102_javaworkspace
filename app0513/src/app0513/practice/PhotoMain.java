package app0513.practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PhotoMain extends JFrame{
	JPanel p_north;
	XPanel p_center;
	String dir="C:\\korea202102_javaworkspace\\app0513\\res\\images\\";
	Image[] imageAr;
	String[] filename={"aa.jpg", "ab.jpg","ax.jpg","bm.jpg","et.jpg","kg.jpg","mx.jpg","pk.jpg","ub.jpg","ya.jpg"};
	Toolkit kit;
	
	
	public PhotoMain() {
		//생성
		p_north=new JPanel();
		p_center=new XPanel();
		imageAr=new Image[filename.length];
		kit=Toolkit.getDefaultToolkit();
		for(int i=0; i<filename.length; i++) {
			Image image=kit.getImage(dir+filename[i]);
			imageAr[i]=image;
			ThumbPanel thumbPanel=new ThumbPanel(imageAr[i],p_center);
			thumbPanel.setPreferredSize(new Dimension(50,50));
			p_north.add(thumbPanel);
		}
		
		//스타일
		p_north.setPreferredSize(new Dimension(500,60));
		p_north.setBackground(Color.white);
		p_center.setBackground(Color.yellow);
		//조립
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		//보여주기
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,500,500);
	}
	public static void main(String[] args) {
		new PhotoMain();
	}
}
