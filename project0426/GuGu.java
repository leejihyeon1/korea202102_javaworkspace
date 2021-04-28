/*이중포문으로 구구단 출력*/
class GuGu 
{
	public static void main(String[] args) 
	{
		//main의 매개변수는 java.exe 호출시 그 값을 넘길 수 있다..
		//java 사과 딸기 바나나  <-- 매개변수에 크기가 3인 String배열이 전달
		
		int n = Integer.parseInt(args[0]);
		System.out.println("몇단 출력? "+n);
		//넘겨받은 배열의 길이만큼 반복문 실행
		for(int i=n; i>=1; i--){
				System.out.println("----------"+i+"단----------");
			for(int j=1; j<=9; j++){
				System.out.println(i+"*"+j+"="+(i*j));
			}		
		}
	}
}
