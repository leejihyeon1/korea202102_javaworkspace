package db.table;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

//DBMS등의 표형식(2차원 구조)의 데이터를 표현하는 최적화된 JTable을 잉요해본다
public class TableBasic extends JFrame{
	//table 생성자 중, 레코드는 이차원배열로 지원하고, 컬럼의 제목은 일차원배열로 지원하는 3번째 생성자를 이용해보자!
	String[] columns= {"member_id","user_id","password","name","regdate"};
	String[][] rows= {};
	String url="jdbc:mysql://localhost:3307/javase?characterEncoding=UTF-8";
	String user="root";
	String password="1234";
	Connection con;//접속 후 그 정보를 가진 객체
	JTable table;
	JScrollPane scroll;
	
	public TableBasic() {
		 connect();//JTable이 사용할 이차원 배열을 먼저 구해야하므로..
		 
		table=new JTable(rows,columns);
		scroll=new JScrollPane(table);
		
		add(scroll);
		
		setVisible(true);
		setBounds(600, 600, 500, 250);
		//setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		

	}
	//데이터베이스 가져오기
	public void connect() {
		/*
		 * 드라이버로드
		 * 접속
		 * 쿼리수행
		 * 자원해제
		 * */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			JOptionPane.showMessageDialog(this, "mysql 드라이버 로드 성공");
			
			con=DriverManager.getConnection(url,user,password);
			if(con!=null) {
				JOptionPane.showMessageDialog(this, "접속 성공");
				select();
			}else {
				JOptionPane.showMessageDialog(this, "접속 실패");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//select문을 수행하는 메서드 정의 
	public void select() {
		PreparedStatement pstmt=null;//쿼리 수행 객체
		ResultSet rs=null;
		String sql="select * from member";
		
		try {
			//스크롤 가능하면서 읽기 전용의 ResultSet을 생성할 수 있다
			pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=pstmt.executeQuery();
			
			//rs의 데이터를 이차원 배열로 변환하여,JTable에게 적용시켜보자!!
			//rs에는 총 레코드 수를 반환해주는 메서드가 별도로 지원되지 않는다.. 따라서 개발자가 다음의 절차를 거쳐
			//총 레코드 수를 구할 수 있다..
			//1.커서를 레코드의 제일 마지막으로 이동(last())
			//2.마지막으로 이동된 커서의 rownumber를 구한다. 여기서 넘버란 몇번째 레코드인지에 대한 순번이다..
			rs.last();
			int num=rs.getRow();//현재 레코드의 순번을 반환받자
			System.out.println("저의 현재 위치는 "+num);
			
			String[][] data=new String[num][columns.length];
			
			rs.beforeFirst();//last에 가ㅣ있는 rs의 커서를 다시 처음으로 원상복귀 시키자!
			//rs.next();//커서 한칸 전진!
			int index=0;
			while(rs.next()) {
				
				//rs의 레코드에 접근하여, empty상태에 있는 2차원배열로 데이터를 옮겨보자!
				data[index][0]=Integer.toString(rs.getInt("member_id"));//int형을 string객체형으로 변환@
				data[index][1]=rs.getString("user_id");
				data[index][2]=rs.getString("password");
				data[index][3]=rs.getString("name");
				data[index][4]=rs.getString("regdate");
				
				index++;
			}
			
			rows=data;//JTable이 참조할 예정인 rows의 주소값을 data이차원배열로 대체해버리자!
//			System.out.println(data[0][1]);
//			
//			table.setValueAt(Integer.toString(rs.getInt("member_id")), num, num);//어떤 데이터를 몇층 몇호수에 넣을래?
//			table.setValueAt(rs.getString("user_id"), num, num);//어떤 데이터를 몇층 몇호수에 넣을래?
//			table.setValueAt(rs.getString("password"), num, num);//어떤 데이터를 몇층 몇호수에 넣을래?
//			table.setValueAt(rs.getString("name"), num, num);//어떤 데이터를 몇층 몇호수에 넣을래?
//			table.setValueAt(rs.getString("regdate"), num, num);//어떤 데이터를 몇층 몇호수에 넣을래?
//			table.updateUI();//갱신된 데이터를 이용하여 JTable도 update
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new TableBasic();
	}

}
