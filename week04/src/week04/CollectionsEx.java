package week04;

import java.util.*;
import static java.util.Collections.*;

class CollectionsEx {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(list);
		
		addAll(list, 1, 2, 3, 4, 5);
		System.out.println(list);
		
		rotate(list, 2); // 오른쪽으로 두칸씩 이동
		System.out.println(list);
		
		swap(list, 0, 2); // 첫번째와 세번째를 교환
		System.out.println(list);
		
		shuffle(list); // 저장된 요소의 위치를 임의로 변경
		System.out.println(list);
		
		sort(list, reverseOrder()); // 역순 정렬
		System.out.println(list);
		
		sort(list);
		System.out.println(list);
		
		int idx = binarySearch(list, 3); // 3이 저장된 위치 반환
		System.out.println("index of 3 = " + idx);
		
		System.out.println("max = " + max(list));
		System.out.println("min = " + min(list));
		System.out.println("min = " + max(list, reverseOrder()));
		
		fill(list, 9); // list를 9로 채움
		System.out.println("list = " + list);
		
		// list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 단, 결과는 변경불가
		List<Integer> newList = nCopies(list.size(), 2);
		System.out.println("newList = " + newList);
		
		System.out.println(disjoint(list, newList)); // 공통 요소가 없으면 true
		
		copy(list, newList);
		System.out.println("list = " + list);
		System.out.println("newList = " + newList);
		
		replaceAll(list, 2, 1);
		System.out.println(list);
		
		Enumeration<Integer> e = enumeration(list);
		ArrayList<Integer> list2 = list(e);
		
		System.out.println("list2 = " + list2);
	}

}
