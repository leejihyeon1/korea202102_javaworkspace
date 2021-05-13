package app0510.gugudan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ActionControl implements ActionListener{
	JTextField t_input;
	
	public ActionControl(JTextField t_input) {
		this.t_input=t_input;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int dan=Integer.parseInt(t_input.getText());
		printDan(dan);
	}
	
	public void printDan(int dan) {
		for(int i=1; i<=9; i++) {
			System.out.println(dan+"*"+i+"="+(dan*i));
		}
	}

}
