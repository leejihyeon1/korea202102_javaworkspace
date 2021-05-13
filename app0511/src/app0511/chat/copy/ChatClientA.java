package app0511.chat.copy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientA extends JFrame implements KeyListener,ActionListener{
	JButton bt_open;//대화 상대방을 띄우기 위한 버튼
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	ChatClientB cb;
	ChatClientC cc;
	
	public ChatClientA() {
		//생성
		bt_open=new JButton("열기");
		area=new JTextArea();
		scroll=new JScrollPane(area);
		t_input=new JTextField(20);
		bt=new JButton("전송");
		
		//스타일,레이아웃
		this.setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(280,280));
		area.setBackground(new Color(250,255,0));
		
		//조립
		this.add(bt_open);
		this.add(scroll);//area를 scroll이 잡아먹기 때문에 scroll만 부착해도 됨!
		this.add(t_input);
		this.add(bt);
		
		//이벤트 리스너와의 연결
		//특히 이벤트리스너가 연결된 컴포넌트를 가리켜 이벤트 소스라 한다!
		bt.addActionListener(this);
		bt_open.addActionListener(this);
		t_input.addKeyListener(this);
		
		//보여주기
		this.setBounds(300, 100, 350, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		if(key==KeyEvent.VK_ENTER) {
			showText();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//열기버튼 누르면
		if(e.getSource()==bt_open) {
//			System.out.println("열기");
//			chatclientb가 태어나도록 하자
			cb=new ChatClientB();
			cb.setArea2(area);
			cc=new ChatClientC();
			cc.setArea2(area);
			cb.setCc(cc);
			cc.setCb(cb);
			
		}else if(e.getSource()==bt) {//전송버튼 누르면
//			System.out.println("전송");
			showText();
		}
	}

	//전송처리
	public void showText() {
		//textfield값 가져오기
		String msg=t_input.getText();
		//textarea에 누적
		area.append(msg+"\n");
		//textfield 초기화
		t_input.setText("");
		
		//친구인 상대방 채팅창의 area.append(msg+"\n");
		cb.area.append(msg+"\n");
		cc.area.append(msg+"\n");
	}
	public static void main(String[] args) {
		new ChatClientA();
	}
	
}
