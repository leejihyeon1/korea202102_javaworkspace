/*������������ ������ ���*/
class GuGu 
{
	public static void main(String[] args) 
	{
		//main�� �Ű������� java.exe ȣ��� �� ���� �ѱ� �� �ִ�..
		//java ��� ���� �ٳ���  <-- �Ű������� ũ�Ⱑ 3�� String�迭�� ����
		
		int n = Integer.parseInt(args[0]);
		System.out.println("��� ���? "+n);
		//�Ѱܹ��� �迭�� ���̸�ŭ �ݺ��� ����
		for(int i=n; i>=1; i--){
				System.out.println("----------"+i+"��----------");
			for(int j=1; j<=9; j++){
				System.out.println(i+"*"+j+"="+(i*j));
			}		
		}
	}
}
