package com.minssam.shoppingapp.util;

//앞으로, 파일과 관련된 여러 작업을 전담하게 될 파일 제어 클래스 정의
public class FileManager {

	//넘겨받은 경로를 통해 확장자만 추출해보기
	public static String getExtend(String path, String string) {
		int lastIndex=path.lastIndexOf("\\");//넘겨받은 문자열내의 가장 마지막 디렉토리 구분자의 위치
		//System.out.println(lastIndex);
		//String str="korea";
		//System.out.println(str.substring(0, 2));
		String filename=path.substring(lastIndex+1,path.length());
		String ext=filename.substring(filename.lastIndexOf(".")+1,filename.length());
		return ext;
	}
}
