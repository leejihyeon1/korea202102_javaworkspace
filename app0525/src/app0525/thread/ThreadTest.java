package app0525.thread;
/*하나의 프로그램 즉 하나의 프로세스 내에서 각각 */
public class ThreadTest {
	public static void main(String[] args) {

		MyThread t1=new MyThread("☆");
		MyThread t2=new MyThread("★");
		
		t1.start();//run을 호출
		t2.start();//run을 호출
	}
}