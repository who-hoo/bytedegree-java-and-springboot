package ch4;

class Exercise4_04 {

	public static void main(String[] args) {
		int total = 0;
		int i = 1;
		
		while(true) {
			total = total + i;
			if (total >= 100) break;
			i = (i+1)*(-1);
		}
		
		System.out.println(i);
	}

}
