package app0513.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

//자바의 컬렉션 프레임웍 중 Map을 학습한다
//Map이란 Key-Value의 쌍으로 이루어진 데이터 집합이다.. 대표적인 예 JSON..
public class MapApp {
	public static void main(String[] args) {
		HashMap<String,String> map=new HashMap<String,String>();//제너릭<> 지정 안하면 get 반환형이 object형임
		map.put("fruit1","apple");//데이터 넣기
		map.put("fruit2","pineapple");
		map.put("fruit3","pear");
		
		//map.get("fruit3");//key값으로 출력
		//결론: 직접 Iterator나 Enumeration으로 변환할 수는 없고, Set을 한번 거쳐서 처리한다!
		//			중복을 허용하지만 key값은 중복될 수 없다!!
		
		Set<String> set=map.keySet();//fruit1,fruit2,fruit3..이 순서 없이 모여있게 됨
		Iterator<String> it=set.iterator();//이름을 일렬로 늘어서게 함
		
		//반복문으로 모든 요소 출력
		while(it.hasNext()) {
			String key=it.next();//키를 얻었기 때문에 이 시점에서 Map에 들어있는 데이터를 검색할 수 있다
			String value=map.get(key);
			System.out.println(value);
		}
	}
}
