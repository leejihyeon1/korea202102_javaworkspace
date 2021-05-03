package animal.birds;

class UseDuck{
	//오리 한마리를 메모리에 올리고,(인스턴스 생성)canSwim 메서드를 호출해보자
	public static void main(String[] args){
		Duck d=new Duck("red");
		d.canSwim();

		Bird b= new Bird();
		d=b; //모든 새를 오리로,,,

		//byte short int long : 숫자형은 서로 같은 종류의 자료형이다!
		//즉 같은 종류의 자료형이기에 서로 형 변환이 가능하다!
		byte b=5;
		int k=b;

		// 객체형도 자료형이다..
	}
}