/*이 클래스는 현실의 사물을 표현하기 위함이 아닌, 단지 메인을 두기 위한 ..
즉 실행용 클래스일 뿐이다*/
class UseDog{
   public static void main(String[] args){
	 //강아지 2마리를 메모리에서 뛰어놀게 해보자!
	 //뛰어놀게 하려면 메모리에 올려야 하고, 메모리에 올리려면 실행을 해야한다
	 //또한 거푸집에 불과했던 강아지의 인스턴스를 생성해야 한다..
	 //String name=new Dog().getName();
	 //System.out.println(name);

	 //강아지 1마리를 메모리에 올리고, 그 강아지의 나이를 3세로 바꾼 후 변경된 나이 출력
	 //자바와 같은 객체지향언어에서 개발자가 자료형을 정의할 수 있다
	 //이 정의는 클래스를 단위로 작성할 수 있다.. 그리고 개발자가 정의한 자료형을 가리켜
	 //'사용자 정의 자료형'이라 한다. 따라서 개발자가 Dog라는 클래스를 정의했다면
	 //그것은 Dog형을 새롭게 탄생시킨 것이다! 이 시점부터는 oop언어에서 자료형이 총 4개라고 할수있다
	 Dog d1=new Dog();
	 System.out.println("강아지의 변경 전 나이는 "+d1.getAge());
	 d1.age=3;//d1이라는 개가 보유한 age속성값을 3으로 변경
	 System.out.println("강아지의 변경 후 나이는 "+d1.getAge());

	 //d1이라는 강아지의 이름을 하니로 변경 후 출력
	 System.out.println("강아지의 변경 전 이름은 "+d1.getName());
	 d1.name="하니";
	 System.out.println("강아지의 변경 후 이름은 "+d1.getName());
   }
}