package animal.birds;

class UseDuck{
	//���� �Ѹ����� �޸𸮿� �ø���,(�ν��Ͻ� ����)canSwim �޼��带 ȣ���غ���
	public static void main(String[] args){
		Duck d=new Duck("red");
		d.canSwim();

		Bird b= new Bird();
		d=b; //��� ���� ������,,,

		//byte short int long : �������� ���� ���� ������ �ڷ����̴�!
		//�� ���� ������ �ڷ����̱⿡ ���� �� ��ȯ�� �����ϴ�!
		byte b=5;
		int k=b;

		// ��ü���� �ڷ����̴�..
	}
}