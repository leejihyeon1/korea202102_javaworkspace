package shop;

//아래의 클래스에 대해 변수는 private, 이 변수들에 대한 getter, setter
//=은닉화 , 캡슐화(encapsulation)
public class Customer{
	private String name;
	private int age;
	private boolean isMarry;

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}

	public void setAge(int age){
		this.age=age;
	}
	public int setAge(){
		return age;
	}
	
	public void setIsMarry(boolean isMarry){
		this.isMarry=isMarry;
	}
	public boolean getIsMarry(){
		return isMarry;
	}
}