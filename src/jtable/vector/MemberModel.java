package jtable.vector;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

//member테이블의 전용 tablemodel
public class MemberModel extends AbstractTableModel{
	Vector<Member> data=new Vector<Member>();
	Vector<String> column=new Vector<String>();
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return column.size();
	}
	@Override
	public String getColumnName(int col) {
		// TODO Auto-generated method stub
		return column.get(col);
	}
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		String value=null;
		Member member=data.get(row);
		if(col==0) {
			value=Integer.toString(member.getMember_id());
		}else if(col==1) {
			value=member.getUser_id();
		}else if(col==2) {
			value=member.getPassword();
		}else if(col==3) {
			value=member.getName();
		}else if(col==4) {
			value=member.getRegdate();
		}
		return value;
	}

}
