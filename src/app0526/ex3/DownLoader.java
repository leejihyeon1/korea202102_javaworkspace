package app0526.ex3;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import util.FileManager;
import util.ImageManager;

//웹상의 자원을 수집하고,다운로드 받는 진행 상황을 프로그래스바로 표현하자
public class DownLoader extends JFrame{
	JTextField t_url;
	JButton bt;
	JProgressBar bar;
	ImageManager imageManager=new ImageManager();
	ImageIcon icon;//icon 인터페이스를 구현한 클래스
	InputStream fis;
	FileOutputStream fos;
	HttpURLConnection httpCon;
	Thread thread;
	
	public DownLoader() {
		t_url=new JTextField();
		//resource 폴더로 등록된 자원은 클래스 패스를 통해 접근해야 한다
		//그리고 클래스패스와 관련된 정보를 얻으려면, class 클래스를 이용하면 된다
		//자바의 클래스 중 class에 대한 정보를 가진 클래스가 class이다!! 이 class 클래스를 이용하면, 클래스코드를 
		//static에 올릴 수 있고(class.forname("드라이버명")), 해당 클래스가 가진 메서드, 속성등을 추출할 수도 있다	
		//Class myClass=this.getClass();
		//Method[] methods=myClass.getMethods();//이 클래스가 보유한 메서드 목록을 method객체배열로 반환
		//System.out.println("이 클래스가 보유한 메서드의 개수는 "+334);
		
		//개발자가 특정 디렉토리를 resource로 등록하면, getresource()메서드로 클래스 패스를 이용하여 접근이 가능
		bt=new JButton(imageManager.getScaledIcon("bt.png", 45, 38));
		bar=new JProgressBar();
		
		setLayout(new FlowLayout());
		t_url.setPreferredSize(new Dimension(470,35));
		bar.setPreferredSize(new Dimension(470,35));
		bt.setPreferredSize(new Dimension(45,38));
		bt.setBorder(null);
		
		add(t_url);
		add(bt);
		add(bar);
		
		bt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thread=new Thread() {
					public void run() {
						downLoad();
						JOptionPane.showMessageDialog(DownLoader.this, "다운로드 완료");
					}
				};
				thread.start();
			}
		});
		
		setVisible(true);
		setBounds(500,100,500,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void downLoad() {
		try {
			URL url=new URL(t_url.getText());
			httpCon=(HttpURLConnection)url.openConnection();
			httpCon.setRequestMethod("GET");
			fis=httpCon.getInputStream();//서버의 자원과 입력 스트림 연결
			
			//파일의 총 크기 구하기
			int total=httpCon.getContentLength();
			System.out.println("total은 "+total);
			
			//파일명 결정
			long time=System.currentTimeMillis();
			String ext=FileManager.getExtend(t_url.getText(), "/");
			String filename=time+"."+ext;
			fos=new FileOutputStream("C:\\korea202102_javaworkspace\\app0526\\data\\"+filename);//저장할 파일명 결정
			
			int data=-1;
			int count=0;
			
			while(true) {
				data=fis.read();//1byte 읽기
				//count와 total의 비율을 이용하여 백분율을 구한 후, 프로그래스바에 반영해보자!
				float percent=(count/(float)total)*100;
				System.out.println("percent = "+(int)percent);
				
				bar.setValue((int)percent);
				
				if(data==-1)break;
				count++;//데이터가 존재할때만 증가시키자!
				fos.write(data); //1byte출력
				
			}
			System.out.println("count는 "+count);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new DownLoader();
	}
}
