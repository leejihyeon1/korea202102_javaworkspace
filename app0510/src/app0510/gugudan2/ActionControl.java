package app0510.gugudan2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionControl implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		int dan=new KeyControl().dan;
		printDan(dan);	
	}
	
	public void printDan(int dan) {
		for(int i=1; i<=9; i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}
	}

}
