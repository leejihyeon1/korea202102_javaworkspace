class Phone{
	int price=5000;
	String name="G21";
	static String company="Samsung";//static�� '��������'�̶� ���� �����ڶ� �Ҹ���
														//��ƼĿ ���� �� �ٿ�����!!!
														//�޼���� new�Ҷ� �ش� �ν��Ͻ��� �Ҽӵ��� �ʴ´�
														//���� ���� Ŭ������ �����ϰ� �ȴ� 
														//static���� ����� ��� ������ 'Ŭ��������'�� �Ѵ�

	public void ring(){
		System.out.println("���� �����");
	}
	public static void main(String[] args){
		//String c=Phone.company //Ŭ������ ������ Ŭ���������� �̷��� �����ϴ� �Ŵ�!
		Phone p1= new Phone(); 
		p1.company="LG";//�ν��Ͻ��� ������ ���� ���� !

		company="Motor";

		Phone p2=new Phone();
		p2.company="Sambo";

		System.out.println(p1.company);
	}

}