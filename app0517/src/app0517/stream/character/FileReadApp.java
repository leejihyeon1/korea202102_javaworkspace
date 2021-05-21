package app0517.stream.character;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//문자기반 스트림을 학습하면서, 동시에 한계점도 알아보자!
public class FileReadApp {
	FileReader reader;
	BufferedReader buffr;//문자를 대상으로 한줄씩 읽을 수 있는 스트림
	File file;
	String path="C:\\korea202102_javaworkspace\\app0517\\res\\자바13일차.txt";
	public FileReadApp() {
		try {
			reader=new FileReader(file=new File(path));//파일을 대상으로 빨대를 꽂음!
			buffr=new BufferedReader(reader);
			String data=null;
			while(true) {
				data=buffr.readLine();//한줄을 읽어들임..따라서 반환형은 문자열임
				if(data==null)break;//파일의 끝을 만나면 -1 반환하므로 반복문 멈추기
				System.out.println(data);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(buffr!=null) {
				try {
					buffr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
		new FileReadApp();
	}
}
