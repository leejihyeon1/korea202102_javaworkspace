package app0504;

import java.awt.*;


public class Study2 {
	public static void main(String[] args) {
		Frame frame=new Frame();
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 200);
		frame.setVisible(true);
		
		//전체적으로 2등분
		//위에 판넬
		Panel p1=new Panel();
		p1.setLayout(new GridLayout(2,2));
		p1.setBackground(Color.yellow);
		Panel mini_p1=new Panel();
		Panel mini_p2=new Panel();
		Panel mini_p3=new Panel();
		Panel mini_p4=new Panel();
		
		Label l1=new Label("ID");
		Label l2=new Label("PASS");
		
		TextField t1=new TextField(20);
		TextField t2=new TextField(20);
		
		mini_p1.add(l1);
		mini_p2.add(t1);
		mini_p3.add(l2);
		mini_p4.add(t2);
		
		p1.add(mini_p1);
		p1.add(mini_p2);
		p1.add(mini_p3);
		p1.add(mini_p4);
		
		
		
		//아래 판넬
		Panel p2=new Panel();
		Button bt1=new Button("LOGIN");
		Button bt2=new Button("REGIST");
		
		p2.add(bt1);
		p2.add(bt2);
		
		frame.add(p1,BorderLayout.CENTER);
		frame.add(p2,BorderLayout.SOUTH);
		
		
		
	}
}
