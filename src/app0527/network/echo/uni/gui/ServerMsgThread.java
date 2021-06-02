package app0527.network.echo.uni.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

//에코서버는 접속자마다 소켓을 유지할 수 없기에, 아래의 클래스를 정의하여, 인스턴스변수로 보관하고,
//이 소켓을 통한 클라이언트와의 메세지 송수신을, 아래의 클래스로부터 생성되는 인스턴스가 각각 독립적으로 
//실행할 수 있도록 쓰레드로 구현해보자!
public class ServerMsgThread extends Thread{
	Socket socket;//바늘
	BufferedReader buffr;//실 관게
	BufferedWriter buffw;
	JTextArea area;
	
	public ServerMsgThread(Socket socket,JTextArea area) {
		this.socket=socket;
		this.area=area;
		
		try {
			buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//듣고 (=입력)
	public void listen() {
		String msg=null;
		try {
			msg=buffr.readLine();
			send(msg);
			//서버로그에 메세지 남기기
			area.append(msg+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//말하고 (=출력)
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//클라이언트와 끝없는 대화를 나눌 수 있도록 구현할 예정..
	@Override
	public void run() {
		while(true) {
			listen();
			
		}
	}
	

}
