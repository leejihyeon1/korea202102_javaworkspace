package app0601.json.chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


//loginform 예제에서는 메인 메서드 안에 변수를 몰아넣고, 즉 지역 변수로 객체들을 처리하고 있다..
//이번엔 oop언어에서의 is a, has a 관계를 활용하여 객체를 정의해보자!
public class LoginForm extends JFrame{
									/* is a */
	JLabel la_id;
	JLabel la_pass;
	JTextField t_id;
	JTextField t_pass;
	JButton bt_login;
	JButton bt_join;
	
	JPanel p_center;
	JPanel p_south;

	Connection con;
	String url="jdbc:mysql://localhost:3307/javase";
	String user="root";
	String password="1234";
	//이 윈도우인 즉, 로그인 폼이 메모리에 생성될때 해당 부품들도 같이 생성시키려면
	//생성자 메서드를 적극 활용해야 한다..
	public LoginForm() {
		//제목만들기
		super("loginform");
		
		//부품 생성
		la_id=new JLabel("ID");
		la_pass=new JLabel("Pass");
		t_id=new JTextField(20);//20자 너비
		t_pass=new JTextField(20);
		bt_login=new JButton("login");
		bt_join=new JButton("join");
		p_center=new JPanel();
		p_south=new JPanel();
		
		//스타일 설정
		la_id.setPreferredSize(new Dimension(110,35));
		t_id.setPreferredSize(new Dimension(110,35));
		la_pass.setPreferredSize(new Dimension(110,35));
		t_pass.setPreferredSize(new Dimension(110,35));
		//조립
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);
		p_south.add(bt_login);
		p_south.add(bt_join);
		
		//패널을 윈도우 센터에 부착
		this.add(p_center);
		this.add(p_south,BorderLayout.SOUTH);
		
		bt_login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Member member=loginCheck();
				
				if(loginCheck()==null) {
					JOptionPane.showMessageDialog(LoginForm.this, "로그인 정보가 올바르지 않습니다");
				}else {
					//채팅창 띄우고 회원정보 전달
					new ChatClient(member);
					LoginForm.this.setVisible(false);
				}
				
			}
		});
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				release(con);
				System.exit(0);
			}
		});
		//윈도우의 크기 설정과 윈도우 보이게 설정
		//this 생략 가능!!!!!!
		this.setSize(370,155);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setTitle("로그인"); 제목만들기
		
		connect();
	}
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");//드라이버 로드
			con=DriverManager.getConnection(url,user,password);
			if(con!=null) {
				this.setTitle("접속 성공");
			}else {
				this.setTitle("접속 실패");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//로그인처리
	public Member loginCheck() {
		String sql="select * from member where user_id=? and password=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member member=null;//반환할것임 
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, t_id.getText());
			pstmt.setString(2, t_pass.getText());
			
			rs=pstmt.executeQuery();
			
			//레코드가 있다면, 즉 로그인이 인증되었다면 커서 한칸 전진이 가능한것임
			if(rs.next()) {
				//로그인창을 닫고 채팅창 열기! 단, rs에 들어있는 회원정보를 vo에 담기도 하자!
				member=new Member();//empty상태
				member.setMember_id(rs.getInt("member_id"));
				member.setUser_id(rs.getString("user_id"));
				member.setPassword(rs.getString("password"));
				member.setName(rs.getString("name"));
				member.setRegdate(rs.getString("regdate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return member;
	}
	public void release(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new LoginForm();
	}
}
