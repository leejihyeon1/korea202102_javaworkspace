package vehicle;

class UseCar{
	public static void main(String[] args){
		Car car=new ElectCar(); //오버라이딩이 발생하면 부모자료형이라도 자식을 최우선으로 봄
		car.turnOnLight();
		car.tick();//여기서 car변수는 부모인 Car역할을 한게 아닌
					   // 자식인 ElectCar역할을 수행한 것이다.. 즉 다형성이 적용된것!
					   //자바의 객체가 여러 자료형의 역할을 수행하는 모습을 가리켜 다형성이라함!
		car.stop();

		/*
		원칙) 상속관계에 있는 인스턴스는 자료형을 기준으로 찾아가서 사용하면 된다..
			ex) Bird b=new Duck();
				  b.으로 접근할 수 있는 인스턴스는 Bird의 인스턴스를 접근
			예외) 단, 자식이 부모의 메서드를 오버라이드 했을 때는 레퍼런스 변수가 부모이건
					자식이건 무조건 업그레이드 된 메서드를 최우선으로 호출한다!!
		*/
	}
}