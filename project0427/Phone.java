class Phone{
	int price=5000;
	String name="G21";
	static String company="Samsung";//static은 '고정적인'이란 뜻의 수정자라 불린다
														//스티커 역할 딱 붙여놓음!!!
														//메서드는 new할때 해당 인스턴스에 소속되지 않는다
														//따라서 원본 클래스에 존재하게 된다 
														//static으로 선언된 멤버 변수를 '클래스변수'라 한다

	public void ring(){
		System.out.println("벨이 울려요");
	}
	public static void main(String[] args){
		//String c=Phone.company //클래스가 보유한 클래스변수는 이렇게 접근하는 거다!
		Phone p1= new Phone(); 
		p1.company="LG";//인스턴스엔 없지만 참조 가능 !

		company="Motor";

		Phone p2=new Phone();
		p2.company="Sambo";

		System.out.println(p1.company);
	}

}