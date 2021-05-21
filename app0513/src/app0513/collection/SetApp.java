package app0513.collection;

import java.util.HashSet;
import java.util.Iterator;


//자바의 컬렉션 프레임웍 객체 중 순서 없는 데이터를 모아서 처리할 수 있는 set을 알아보자!
public class SetApp {
	public static void main(String[] args) {
		HashSet<String> set=new HashSet<String>();
		set.add("banana");//list와 동일하게 add()메서드가 지원되는 이유는? 모두 collection객체의 자식이기 때문에...
		set.add("apple");//list와 동일하게 add()메서드가 지원되는 이유는? 모두 collection객체의 자식이기 때문에...
		set.add("mango");//list와 동일하게 add()메서드가 지원되는 이유는? 모두 collection객체의 자식이기 때문에...
		//실험 결론 : Set은 데이터 중복을 허용하지 않음!!
		
		//순서가 없는 데이터형이므로, 일렬로 늘어서게 해보자
		Iterator<String> it= set.iterator();
		
		//반복문을 이용해서 모든 요소 출력하기
		while(it.hasNext()) {//현재 위치를 기준으로, 다음 위치에 요소가 존재하는 동안만 반복문 수행
			String item=it.next();//이동한 위치의 요소를 반환함
			System.out.println(item);
			}
		}
		
	}

