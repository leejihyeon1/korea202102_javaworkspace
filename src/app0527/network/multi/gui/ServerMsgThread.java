package app0527.network.multi.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JTextArea;

//에코서버는 접속자마다 소켓을 유지할 수 없기에, 아래의 클래스를 정의하여, 인스턴스변수로 보관하고,
//이 소켓을 통한 클라이언트와의 메세지 송수신을, 아래의 클래스로부터 생성되는 인스턴스가 각각 독립적으로 
//실행할 수 있도록 쓰레드로 구현해보자!
public class ServerMsgThread extends Thread{
	Socket socket;//바늘
	BufferedReader buffr;//실 관게
	BufferedWriter buffw;
	JTextArea area;
	Vector<ServerMsgThread> clientList;
	
	public ServerMsgThread(Socket socket,JTextArea area,Vector<ServerMsgThread> clientList) {
		this.socket=socket;
		this.area=area;
		this.clientList=clientList;
		
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
			//아래의 코드를, 개선해보자
			//현재 서버에 접속한 모든~~ 메세지쓰레드 객체의 "말" 즉 전송메서드를 호출!
			//multicasting임!
			for(int i=0; i<clientList.size();i++) {
				ServerMsgThread msgThread=clientList.get(i);
				msgThread.send(msg);		
			}
			
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
				
				//아래의 listen()메서드는, 클라이언트가 원하는 시점에 호출할 사항이 아니라, 항상 무한루프로
				//되어 있어야, 서버의 메세지를 실시간으로 감지할 수 있다..
				//이때 주의할 점은, 메인쓰레드를 무한루프에 빠지게 해서는 안된다!! 결국 쓰레드를 생성하여 listen()을 전담시키자
				
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
