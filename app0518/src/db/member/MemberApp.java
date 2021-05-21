package db.member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemberApp extends JFrame{
	JPanel p_north,p_west,p_center;
	//북쪽관련
	JTextField t_url,t_port;
	JButton bt_connect;
	
	//서쪽관련
	JTextField t_user_id;
	JPasswordField t_password;
	JTextField t_name;
	JButton bt_regist,bt_list;
	
	//가운데 관련
	JTextArea area;
	JScrollPane scroll;
	
	Connection con;
	
	public MemberApp() {
		//생성
		p_north=new JPanel();
		p_west=new JPanel();
		p_center=new JPanel();
		t_url=new JTextField(20);
		t_port=new JTextField(10);
		bt_connect=new JButton("접속");
		
		t_user_id=new JTextField(10);
		t_password=new JPasswordField(10);
		t_name=new JTextField(10);
		bt_regist=new JButton("등록");
		bt_list=new JButton("목록");
		
		area=new JTextArea();
		scroll=new JScrollPane(area);
		
		//스타일,레이아웃
		t_url.setPreferredSize(new Dimension(500,25));
		t_port.setPreferredSize(new Dimension(125,25));
		p_west.setPreferredSize(new Dimension(130,550));
		p_west.setBackground(Color.LIGHT_GRAY);
		
		//조립
		p_north.add(t_url);
		p_north.add(t_port);
		p_north.add(bt_connect);
		
		p_west.add(t_user_id);
		p_west.add(t_password);
		p_west.add(t_name);
		p_west.add(bt_regist);
		p_west.add(bt_list);
		
		add(p_north,BorderLayout.NORTH);
		add(p_west,BorderLayout.WEST);
		add(scroll);
		//리스너연결
		bt_connect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//입력한 url및 포트번호를 가지고 접속할 예정
				connect();
				
			}
		});
		//윈도우와 리스너 연결
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("저 닫아요");
				disConnect();
				//프로세스 죽이기
				System.exit(0);
			}
			
		});
		bt_regist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				regist();
				area.setText("");
				getList();
				
			}
		});
		bt_list.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getList();
				
			}
		});
		//보여주기
		setSize(700, 600);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);//이 메서드는 윈도우 창 닫을 때 무언가 반환할 것이 있을 때는
		//호출해서는 안된다!! 왜?? 이때는 windowlistener의 windowclosing()메서드에서
		//반납할 자원등을 처리해야 하기 때문에,, 그냥 꺼져서 사용하면 안됨
	}
	public void connect() {//DB접속
		try {
			Class.forName("com.mysql.jdbc.Driver");//드라이버 로드
			area.append("드라이버 로드 성공\n");
			String url="jdbc:mysql://"+t_url.getText()+":"+t_port.getText()+"/javase?characterEncoding=UTF-8";
			con=DriverManager.getConnection(url,"root","1234");
			if(con!=null) {
				area.append("접속 성공 \n");
			}else {
				area.append("접속 실패 \n");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			area.append("드라이버 로드 실패\n");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public void regist() {//mysql insert 쿼리문 실행
		PreparedStatement pstmt=null;//쿼리문 수행 객체, 쿼리문마다 일회성 생성해야됨!!!!
		String sql="insert into member(user_id,password,name) values(?,?,?)";
		
		try {
			pstmt=con.prepareStatement(sql);//sql문을 이용하여 pstmt 객체 생성
			//바인드 변수 값 설정
			pstmt.setString(1,t_user_id.getText());
			//password는 char배열로 생성후, 다시 string으로 변환하여 사용하자!
			String str=new String(t_password.getPassword());
			pstmt.setString(2, str);
			pstmt.setString(3, t_name.getText());
			int result=pstmt.executeUpdate();//바로 이 시점에서 쿼리 실행!!!!!!!
			if(result==1) {
				area.append("회원 등록 성공 \n");
			}else {
				area.append("회원 등록 실패 \n");//에러 아님 그냥 데이터가 안들어간것
			}
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
		}
		
	}
	public void disConnect() {//DB접속 해제
		if(con!=null) {//접속이 된 경우에만(접속객체가 메모리에 올라왔을때만)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void getList() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from member";
		
		try {
			pstmt=con.prepareStatement(sql);//쿼리 수행 객체 생성
			rs=pstmt.executeQuery();//수행할 쿼리가 select문인경우 resultset 반환 (데이터베이스 표를 표현, 커서를 통해 움직임)
			
			while(rs.next()) {
				int member_id=rs.getInt("member_id");
				String user_id=rs.getString("user_id");
				String password=rs.getString("password");
				String name=rs.getString("name");
				String regdate=rs.getString("regdate");
				
				area.append("--------------------------------------------------------------------------------------------------------------------------------\n");
				area.append(member_id+"\t"+user_id+"\t"+password+"\t"+name+"\t"+regdate+"\n");
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
	}
	public static void main(String[] args) {
		new MemberApp();
	}

}
