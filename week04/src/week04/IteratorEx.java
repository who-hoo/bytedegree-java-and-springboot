package week04;

import java.util.*;

class IteratorEx {

	public static void main(String[] args) {
		final int ARRAY_SIZE = 10;
		
		ArrayList<String> original = new ArrayList<>(ARRAY_SIZE);
		ArrayList<String> copy1 = new ArrayList<>(ARRAY_SIZE);
		ArrayList<String> copy2 = new ArrayList<>(ARRAY_SIZE);
		
		for (int i = 0; i < ARRAY_SIZE; i++) {
			original.add(i+"");
		}
		
		Iterator<String> it = original.iterator();
		while (it.hasNext()) {
			copy1.add(it.next());
		}
		
		System.out.println("= Original -copy-> copy1 =");
		System.out.println("original: " + original);
		System.out.println("copy1: " + copy1);
		System.out.println();
		
		it = original.iterator();
		while (it.hasNext()) {
			copy2.add(it.next());
			it.remove();
		}
		
		System.out.println("= Original -move-> copy2 =");
		System.out.println("original: " + original);
		System.out.println("copy2: " + copy2);
	}

}
