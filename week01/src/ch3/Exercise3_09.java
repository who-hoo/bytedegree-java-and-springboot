package ch3;

class Exercise3_09 {

	public static void main(String[] args) {
		char ch = 'z';
		boolean answer = 
				('A' <= ch && ch <= 'Z') ||
				('a' <= ch && ch <= 'z') ||
				('0' <= ch && ch <= '9');
		boolean b = answer;
		
		System.out.println(b); // true
	}

}
