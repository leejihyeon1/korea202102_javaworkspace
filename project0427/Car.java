/*�ڵ����� �����غ���*/
class Car{
	String name="����";
	int price=9000;
	String color="sliver";

	public void setPrice(int price){
		this.price=price; //this.price�� ��� ����  price�� ��������
	}
	public static void main(String[] args){
		Car c1=new Car();
		Car c2=new Car();
		Car c3=c2; //c3�� c2�� ����Ű�� �뵵�⶧���� �޸𸮿� c1,c2 2�븸 �ö�

		c1.setPrice(8000); //ù��° �ڵ����� ������ 8000���� ����
		System.out.println(c2.price);//�ι�° �ڵ����� ������ �޾Ҵ��� ���θ� üũ
		//��� : �޸𸮿� �ö� �ν��Ͻ����� ���� �ٸ� ������ ��ü���̴�..!!!!

		c3.setPrice(7000);//c3=c2�̱⶧���� �ι�° �ڵ��� ������ 7000���� �����Ѱ���
		System.out.println(c2.price);
	}
}