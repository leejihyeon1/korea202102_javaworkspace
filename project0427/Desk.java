public class Desk {
	int x;
	static int y;
	
	//�� Ŭ������ Desk�κ��� �ν��Ͻ��� ������ ������, �Ʒ��� �ڵ尡 ����
	{ //�ν��Ͻ� �ʱ�ȭ ��, �������� ���Ұ� ���..
		for(int i=0;i<10;i++){
			x++;
		}
	}
	
	
	static { //static �ʱ�ȭ ��, �����(main�޼��� ȣ���) ������!
		for(int i=0;i<20;i++){
			y++;
		}
	}
	                              
	public static void main(String[] args){
		//System.out.println(x); //C �޸� �ö������ ����, static�������� ���۷��� �������� x�� ������ �� ����..
		int a=new Desk().x; //D
		System.out.println(a); //E
		System.out.println(y); //F
		
	}
}

