package ch3;

class Exercise3_10 {

	public static void main(String[] args) {
		char ch = 'A';
		
		boolean answer1 = 'A' <= ch && ch <= 'Z';
		char answer2 = (char)(ch+32);
		
		char lowerCase = answer1 ? answer2 : ch;
		
		System.out.println("ch : " + ch); // A
		System.out.println("ch to lowerCase : " + lowerCase); // a
	}

}
