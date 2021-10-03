package ch4;

class Exercise4_09 {

	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		
		// String 클래스의 charAt(int i) 사용하여 해결
		for (int i=0; i < str.length(); i++) {
			sum += (str.charAt(i) - '0');
		}
		
		System.out.println("sum="+sum); // 15
	}

}
