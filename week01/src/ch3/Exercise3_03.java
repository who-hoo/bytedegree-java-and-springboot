package ch3;

class Exercise3_03 {

	public static void main(String[] args) {
		int num = 10;
		String answer = num > 0 ? "양수" : num == 0 ? "0" : "음수";
		System.out.println(answer); // "양수"
	}

}
