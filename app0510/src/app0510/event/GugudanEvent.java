package app0510.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

//버튼을 눌렀을 때 해당 이벤트를 청취하는 actionlistener 재정의
public class GugudanEvent implements ActionListener{
	JTextField t;
	
	public GugudanEvent(JTextField t){
		System.out.println("이벤트 클래스 생성시 넘겨받은 t_input은 "+t);
		this.t=t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//나 아닌 다른 클래스에 존재하는 textfield 값에 무엇이 들어있는지 알아맞추기!
		int n=Integer.parseInt(t.getText());
		printDan(n);	
	}
	public void printDan(int n) {
		for(int i=1; i<=9; i++) {
			System.out.println(n+"*"+i+"="+(n*i));
			
		}
	}

}
