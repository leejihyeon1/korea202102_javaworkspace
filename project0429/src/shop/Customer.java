package shop;

//�Ʒ��� Ŭ������ ���� ������ private, �� �����鿡 ���� getter, setter
//=����ȭ , ĸ��ȭ(encapsulation)
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