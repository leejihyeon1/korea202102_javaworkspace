package app0525.thread2;

public class CounterThread extends Thread{
	int count=0;
	//무한 루프로 숫자를 증가시키는 실행단위
	//개발자는 독립적으로 즉 쓰레드로 실행시키고픈 로직을
	//run메서드 안에 작성하면 된다
	@Override
	public void run() {
		while(true) {
			count++;
			System.out.println(count);
			
			//non-runnable영역으로 피신시키기
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//0.5초간 runnable에서 빠져나가 있다가
			//해당시간이 초과되면 다시 runnable로 복귀!
		}
	}
}
