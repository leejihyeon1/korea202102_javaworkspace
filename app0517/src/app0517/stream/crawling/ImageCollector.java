package app0517.stream.crawling;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImageCollector {
	//이 객체는 안드로이드에서도 동일하게 쓰인다!!
	URL url;//url(Uniformed Resource Location : 자원의 위치)
	URLConnection con;//웸서버에 요청을 시도할 수 있는 객체
	HttpURLConnection http;//urlconnection의 자식 객체 즉 http 프로토콜에 최적화된 자식
	String path="http://img.etnews.com/news/article/2021/05/17/cms_temp_article_17094259848980.jpg";
	FileOutputStream fos;//파일을 대상으로 한 바이트기반의 출력스트림
	public ImageCollector() {
		InputStream is=null;
		try {
			url=new URL(path);//url객체 생성
			System.out.println("자원에 접근 가능");
			
			con=url.openConnection();
			http=(HttpURLConnection)con;//다운캐스팅! 같은 자료형이므로 형변ㄴ환 가능!
			http.setRequestMethod("GET");//get방식의 요청
			//웹서버에 요청을 시도해보자!
			is=http.getInputStream();//웹서버와의 요청시 생성된 입력스트림
			fos=new FileOutputStream("C:\\korea202102_javaworkspace\\app0517\\res\\target.jpg");
			
			long startTime=System.currentTimeMillis();//현재시간은 밀리 second로 반환
			//이 입력스트림으로 서버의 자원을 가져올 수 있다..
			int data=-1;
			byte[] b=new byte[1024];//배열의 크기가 바가지의 크기를 결정한다!
			while(true) {
			data=is.read(b);
			if(data==-1)break;
			System.out.println(data);
			fos.write(b);//1byte씩 파일에 내려쓰기!
		}
			System.out.println("인터넷상의 이미지 복사 완료. 디렉토리를 확인하세요");
			long endTime=System.currentTimeMillis();//현재시간은 밀리 second로 반환
			System.out.println("다운로드 소요시간은 "+(endTime-startTime));
			//inputstream은 입력스트림과 관련된 객체들의 최상위 객체 
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("주소가 올바르지 않습니다");//일반인들을 위한 메세지
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fos!=null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(is!=null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new ImageCollector();
	}
}
