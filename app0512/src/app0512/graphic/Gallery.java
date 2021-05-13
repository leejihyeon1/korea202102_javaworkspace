package app0512.graphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Gallery extends JFrame implements ActionListener{
	GalleryDetail galleryDetail;//상세 이미지 그려질 패널
	JPanel p_south;//커스터마이징 할 필요 없으니까 그냥 씀
	JButton bt_prev;
	JButton bt_next;
	//갤러리에 사용할 데이터 즉 배열을 준비하자!
	String dir="C:\\korea202102_javaworkspace\\app0512\\res\\images";
	String[] arr= {"aa.jpg","ab.jpg","ax.jpg","bm.jpg","et.jpg","kg.jpg","ub.jpg","mx.jpg","pk.jpg","ya.jpg"};
	Toolkit kit;
	Image[] image=new Image[arr.length];
	int index=0;
	
	public Gallery() {
		//생성
		galleryDetail=new GalleryDetail();
		p_south=new JPanel();
		bt_prev=new JButton("이전");
		bt_next=new JButton("다음");
		kit=Toolkit.getDefaultToolkit();//인스턴스 얻기!! new하지 않고, 자바에서 준비된 메서드 이용
		
		for(int i=0; i<arr.length; i++) {
			image[i]=kit.getImage(dir+"/"+arr[i]);
		}
		//스타일,레이아웃
		//이미지가 생성되었으므로 0번째 즉 첫번째 이미지를 디폴트로 그려지게 하자
		galleryDetail.setImage(image[index]);
		//버튼 리스너와 연결
		bt_prev.addActionListener(this);
		bt_next.addActionListener(this);
		
		//조립
		add(galleryDetail);
		p_south.add(bt_prev);
		p_south.add(bt_next);
		add(p_south,BorderLayout.SOUTH);
		//보여주기
		setBounds(1000, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//하나의 actionperformed메서드에서 여러 컴포넌트 즉 이벤트 소스를 구분해야한다
		if(e.getSource()==bt_prev) {
			if(index>0) {
				index--;
			}else {
				JOptionPane.showMessageDialog(this, "이전 이미지가 없음");
			}
		}else if(e.getSource()==bt_next) {
			if(index<arr.length-1) {
				index++;
			}else {
				JOptionPane.showMessageDialog(this, "다음 이미지가 없음");
			}	
		}
		//상세보기 객체에 변경된 이미지 보내주기
		galleryDetail.setImage(image[index]);
		galleryDetail.repaint();//다시 그리기 요청
	}
	public static void main(String[] args) {
		new Gallery();
	}
}
