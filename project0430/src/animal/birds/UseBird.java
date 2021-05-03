package animal.birds;

/*
상속에서 놓치지 말아야 할 핵심 주제
1) 코드의 재사용
2) 객체간 형변환(시험 단골 메뉴)
*/
class UseBird{
	public static void main(String[] args){
		int x=7; //4byte 큰 자료형
		byte b=3; //1byte 작은 자료형
	
		//x=b; //가능
		//b=(byte)x; //불가능, 손실 발생 ! 하지만 개발자가 손실을 감안해서라도 강제로 형변환을 명시하면 인정!
						  // (소괄호)를 가리켜 캐스트 연산자라 한다

		//객체 자료형의 형변환의 예
		//앞에있는 자료형이 접근할 인스턴스를 결정한다!!!!!!!

		Bird bird=new Bird("red");
		Duck d=new Duck("white");
		//기본 자료형이 아니기때문에 용량으로 따질 순 없음!
		bird=d; //가능, 객체간 형변환은 누가 더 폭넓은 객체를 가리킬 수 있느냐? 상위자료형이다..큰 자료형..
					//자료형을 duck을 bird형으로 바꿔서 bird 인스턴스만을 참조

		bird.fly();
		//bird.canSwim();//부모가 자식꺼를 쓰는 꼴 , (duck의 부모는 bird)
								//camSwim()메스드가 없다!! 따라서 컴파일 에러!!
		Duck duck=(Duck)bird; //bird를 duck형으로 바꿈
											//객체간의 형 변환도 가능,, 이때 자식 자료형으로의 형 변환을 가리켜
											// downCasting(다운캐스팅)이라한다
		duck.canSwim();
}