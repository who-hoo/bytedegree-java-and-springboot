package ch4;

class Exercise4_04 {

	public static void main(String[] args) {
		int total = 0;
		int s = 1;
		int num = 0;
		
		for(int i=1; total<100; i++, s=-s) {
			num = i*s;
			total += num;
		}
		
		System.out.println(num);
	}

}
