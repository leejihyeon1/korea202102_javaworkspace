/*자동차를 정의해본다*/
class Car{
	String name="벤츠";
	int price=9000;
	String color="sliver";

	public void setPrice(int price){
		this.price=price; //this.price는 멤버 변수  price는 지역변수
	}
	public static void main(String[] args){
		Car c1=new Car();
		Car c2=new Car();
		Car c3=c2; //c3은 c2를 가리키는 용도기때문에 메모리엔 c1,c2 2대만 올라감

		c1.setPrice(8000); //첫번째 자동차의 가격을 8000으로 내림
		System.out.println(c2.price);//두번째 자동차가 영향을 받았는지 여부를 체크
		//결론 : 메모리에 올라간 인스턴스들은 서로 다른 별개의 객체들이다..!!!!

		c3.setPrice(7000);//c3=c2이기때문에 두번째 자동차 가격을 7000으로 변경한거임
		System.out.println(c2.price);
	}
}