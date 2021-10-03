package ch4;

class Exercise4_02 {

	public static void main(String[] args) {
		int total = 0;
		
		for ( int i = 1; i <= 20; i++ ) {
			if (i%2 == 0 || i%3 == 0) {
				continue;
			}
			total = total + i;
		}
		
		System.out.println(total); // 73
	}

}
