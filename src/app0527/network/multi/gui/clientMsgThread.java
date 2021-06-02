package app0527.network.multi.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JTextArea;

//GUI처리를 담당해야할 클라이언트를 대신하여, 메세지를 주고 받을 수 있는
//쓰레드 객체를 정의한다
public class clientMsgThread extends Thread{
	BufferedReader buffr=null;//버퍼처리된 문자기반의 입력스트림
	BufferedWriter buffw=null;//버퍼처리된 문자기반의 출력스트림
	Socket socket;
	JTextArea area;
	
	public clientMsgThread(Socket socket,JTextArea area) {
		this.socket=socket;
		this.area=area;
		
		//접속 성공된 소켓으로부터, 스트림 뽑아놓기!
		try {
			buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//서버에 메세지 보내기
	public void send(String msg) {
		try {
			buffw.write(msg+"\n");
			buffw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//서버의 메세지 받기
	public void listen() {
		String msg=null;
		try {
			msg=buffr.readLine();//서버가 보낸 메세지 받기!
			area.append(msg+"\n");//대화로그에 출력
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true) {
			listen();
		}
	}

}
