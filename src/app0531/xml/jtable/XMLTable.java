package app0531.xml.jtable;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLTable extends JFrame{
	JTable table;
	JScrollPane scroll;
	PetHandler petHandler;
	public XMLTable() {
		table=new JTable();
		scroll=new JScrollPane(table);
		
		add(scroll);
		
		setSize(600,450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		loadXML();
	}
	public void loadXML() {
		SAXParserFactory factory=SAXParserFactory.newInstance();//팩토리의 인스턴스 얻기
		try {
			URL url=this.getClass().getClassLoader().getResource("Pets.xml");
			URI uri=url.toURI();
			SAXParser saxParser=factory.newSAXParser();//파서생성
			saxParser.parse(new File(uri), petHandler=new PetHandler());
			//파싱 후 jtable의 모델 데이터와 파싱한 결과와 매칭
			PetModel model=new PetModel();
			model.data=petHandler.petList;//숙제!
			table.setModel(model);
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	public static void main(String[] args) {
		new XMLTable();
	}
}
