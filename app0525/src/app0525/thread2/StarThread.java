package app0525.thread2;

public class StarThread extends Thread{
	//무한 루프로 별을 출력 시키는 실행단위
	@Override
	public void run() {
		while(true) {
			System.out.println("☆");		
		}
	}
}
