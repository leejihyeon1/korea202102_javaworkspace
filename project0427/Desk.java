public class Desk {
	int x;
	static int y;
	
	//이 클래스이 Desk로부터 인스턴스가 생성될 때마다, 아래의 코드가 실행
	{ //인스턴스 초기화 블럭, 생성자의 역할과 비슷..
		for(int i=0;i<10;i++){
			x++;
		}
	}
	
	
	static { //static 초기화 블럭, 실행시(main메서드 호출시) 동작함!
		for(int i=0;i<20;i++){
			y++;
		}
	}
	                              
	public static void main(String[] args){
		//System.out.println(x); //C 메모리 올라온적도 없고, static영역에서 레퍼런스 변수없이 x를 접근할 수 없다..
		int a=new Desk().x; //D
		System.out.println(a); //E
		System.out.println(y); //F
		
	}
}

