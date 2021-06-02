package app0527.network.multi.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame implements ActionListener{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	
	ServerSocket server;
	Thread thread;//접속자 감지를 처리하기 위한 쓰레드, 얘가 없다면? 메인쓰레드가 대기상태에 빠진다
	
	//접속하는 클라이언트마다 생성되는 servermsgthread의 인스턴스를 컬렉션에 모아놓고 
	//필요할때 그 주소값을 참조하여, servermsgthread를 제어해보자
	//특히 이 컬렉션을 이용하면 현재 서버에 접속한 접속자 수등을 알수있다
	//추후 반복문을 이용할 예정이므로, 순서있는 집합을 다루는 list형을 사용하겠다
	Vector<ServerMsgThread> clientList=new Vector<ServerMsgThread>();
	
	public ChatServer() {
		//생성 
		p_north = new JPanel();
		t_port = new JTextField(10);
		bt = new JButton("서버가동");
		area = new JTextArea();
		scroll  =new JScrollPane(area);
		
		//add
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north, BorderLayout.NORTH);
		add(scroll);
		
		//event 
		bt.addActionListener(this);
		//view
		setVisible(true);
		setBounds(600, 100, 300, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//서버 가동
	public void startServer() {
		int port=Integer.parseInt(t_port.getText());
		
		try {
			server=new ServerSocket(port);
			area.append("서버 생성\n 접속자 기다리는 중...\n");
			
			while(true) {
			//접속자 감지 후, 대화용 쓰레드 반환받자!
			Socket socket=server.accept();//이 코드에 의해 접속자가 발견될 때까지 실행부는 무한대기에 빠지게 된다.. 특히나 무한대기에 빠지게될 
			//실행부가 메인 쓰레드라면, 메인쓰레드의 고유 업무인 이벤트처리,gui처리 등을 할수 없다.. 따라서 프로그램이 먹통된다!
			InetAddress addr=socket.getInetAddress();
			String ip=addr.getHostAddress();
			area.append(ip+"님 접속자 감지!\n");
			
			//곧 사라질 socket을 얼른 servermsgthread의 인스턴스로 보관해놓자
			ServerMsgThread msgThread=new ServerMsgThread(socket,area,clientList);
			msgThread.start();//각각 알아서 움직여라! jvm이 알아서 때려줌..
			
			//메세지쓰레드 객체를 명단에 넣어두자!
			clientList.add(msgThread);
			
			area.append("현재까지 접속자는 "+clientList.size()+"명 \n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		thread=new Thread() {
			@Override
			//개발자는 쓰레드로 처리하고픈 로직을 run에 작성한다
			public void run() {
				startServer();
			}
		};
		thread.start();
		
	}
	public static void main(String[] args) {
		new ChatServer();
	}

}