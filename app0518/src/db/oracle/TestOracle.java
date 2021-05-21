package db.oracle;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;//���� ���� ��, �ش� DB�� ���� ���� ������ ���� ��ü 
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class TestOracle{
	public static void main(String[] args){
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="javase";
		String pass="javase";

		Connection con=null;//���� ���� ��, ���� ������ ���� ��ü
		PreparedStatement pstmt=null;//������ ���� ��ü
		ResultSet rs=null;//select�� ������ �� ��� ǥ ������ ��� ��ü

		/*
		1. ����Ϸ��� DB�� �´� ����̹� �ε�(Ŭ���� �ε�)
			Class.forName("���ϴ� Ŭ������")
		2. DB����
		3. ������ ����
		4. DB���� ��ü ����
		*/
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");//������ ���� ģ�� �޼���

			con=DriverManager.getConnection(url,user,pass);
			if(con!=null){
				System.out.println("���� ����");

				//���� ������ �ƴ�, ������ ������ �� �ִ� ��ü ���� ��, �غ� �ѰŴ�!
				pstmt=con.prepareStatement("select * from member");
				rs=pstmt.executeQuery();//select���� ��� ��ȯ ��ü�� �ֱ� ����..

				//rs.next();//Ŀ�� ��ĭ ����!!
				while(rs.next()){
				/*
				//���� Ŀ���� ����Ű�� row�� �÷����� �ϳ��� �����غ���!!
				int member_id=rs.getInt("member_id");
				String user_id=rs.getString("user_id");
				String password=rs.getString("password");
				String name=rs.getString("name");
				String regdate=rs.getString("regdate");
				*/


				//�÷��� index�ε� �����غ���
				int member_id=rs.getInt(1);
				String user_id=rs.getString(2);
				String password=rs.getString(3);
				String name=rs.getString(4);
				String regdate=rs.getString(5);

				System.out.println(member_id+"\t"+user_id+"\t"+password+"\t"+name+"\t"+regdate);
				}
			}else{
				System.out.println("���� ����");
			}

		}catch(ClassNotFoundException e){
			e.printStackTrace();//�����ڰ� ������ �м��ϱ� ���� ���
			System.out.println("����̹��� ã�� �� ����");//������ ���� ģ�� �޼���
		}catch(SQLException e){//�� �Դ� ����?
			//DriverManager.getConnection()���� ������ �õ��ϴٰ� ������ ���� SQLException,
			//������ ����� ������ ���� SQLException�̴�..
			//�� sun������ ����ȭ��Ű�� �ʾҴ�.. �� SQLException�� �������� ���ܸ� ���..
			e.printStackTrace();
		}finally{
			if(rs!=null){
				try{rs.close();}catch(SQLException e){}	
			}
			if(pstmt!=null){
				try{pstmt.close();}catch(SQLException e){}	
			}
			if(con!=null){
				try{con.close();}catch(SQLException e){}	
			}
		}
	}
}