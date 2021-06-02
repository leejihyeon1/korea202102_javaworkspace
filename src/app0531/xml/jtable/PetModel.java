package app0531.xml.jtable;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

//pet 전용 tablemodel
public class PetModel extends AbstractTableModel{
	Vector<Pet> data=new Vector<Pet>();
	Vector<String> column=new Vector<String>();
	
	public PetModel() {
		column.add("종류");
		column.add("이름");
		column.add("나이");
	}
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
		Pet pet=data.get(row);
		String value=null;
		
		if(col==0) {
			value=pet.getType();
		}else if(col==1) {
			value=pet.getName();
		}else if(col==2) {
			value=Integer.toString(pet.getAge());
		}
		return value;
	}
	
}
