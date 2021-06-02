package app0526.homework;

import javax.swing.JProgressBar;

public class MyThread extends Thread{
	int n;
	int step;
	JProgressBar bar;
	
	public MyThread(JProgressBar bar,int step) {
		this.bar=bar;
		this.step=step;
	}
	public void run() {
		while(true) {
			n+=step;
			bar.setValue(n);			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
