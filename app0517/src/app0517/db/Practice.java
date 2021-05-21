package app0517.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class Practice {
	String url="jdbc:mysql://localhost:3307/javase?characterEncoding=UTF-8";
	String id="root";
	String pass="1234";
	Connection con;
	java.sql.PreparedStatement pstmt;
	
	public Practice() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
			con=DriverManager.getConnection(url, id, pass);
			if(con==null) {
				System.out.println("mysql 접속 실패");
			}else {
				System.out.println("mysql 접속 성공");
				String sql="select * from member order by regdate desc";
				pstmt=con.prepareStatement(sql);
				ResultSet rs=pstmt.executeQuery();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new Practice();
	}
}
