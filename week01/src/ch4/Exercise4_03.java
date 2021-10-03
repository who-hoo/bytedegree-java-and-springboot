package ch4;

class Exercise4_03 {

	public static void main(String[] args) {
		int result = 0;
		
		for(int i=1; i<= 10; i++) {
			for(int j=1; j<= i; j++) {
				result = result + j;
			}
		}
		
		System.out.println(result); // 220
	}

}
