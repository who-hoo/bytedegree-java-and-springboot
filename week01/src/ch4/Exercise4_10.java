package ch4;

class Exercise4_10 {

	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		// 문자열로 변환하지 말고 숫자로만 처리할 것
		while (num >= 1) {
			sum += num % 10;
			num /= 10;
		}
		
		System.out.println("sum="+sum);
	}

}
