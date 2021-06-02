package app0528.json.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//파일로 존재하는 json데이터를 JsonBasic3 예제보다 더 간략화 시켜보자!
public class JsonBasic4 {
	String path;
	FileReader reader;
	
	public JsonBasic4() {
		URL url=this.getClass().getClassLoader().getResource("pet.json");
		
		try {
			File file=new File(url.toURI());
			reader=new FileReader(file);
			JSONParser jsonParser=new JSONParser();
			JSONObject obj=(JSONObject)jsonParser.parse(reader);//이벤엔 string이 아닌 reader
			
			JSONArray petArray=(JSONArray)obj.get("pet");
			for(int i=0; i<petArray.size(); i++) {
				JSONObject pet=(JSONObject)petArray.get(i);
				String type=(String)pet.get("type");
				String gender=(String)pet.get("gender");
				String name=(String)pet.get("name");
				
				System.out.println(type+","+gender+","+name);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new JsonBasic4();
	}
}
