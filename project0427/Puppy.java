class Puppy{
  int age=5;
  boolean hasGuard; // 멤버변수를 개발자가 초기화하지 않으면, 이 클래스로부터 
  							  // 메모리에 올라가는 인스턴스의 변수값에 디폴트값이 적용됨 컴파일러에 의해서 ..
							  //논리값은 false, 정수 0
							  //이 원칙은 멤버변수에만 적용된다..즉 객체의 속성에 대해서만
  public static void main(String[] args){
	  //강아지 1마리의 나이를 3살로 변경후 출력
	 Puppy p= new Puppy();//위 과제를 수행하려면 생물학적으로 강아지가 태어나야 가능
	 p.age=3;
	 System.out.println("변경 후 나이는 "+p.age);
  }
}