package ch4;

class Exercise4_01 {

	public static void main(String[] args) {
		int x = 15;
		char ch = 'x';
		int year = 2021;
		boolean powerOn = false;
		String str = "yes";
		
		boolean exp1 = 10 < x && x < 20;
		boolean exp2 = !(ch == ' ' || ch == '\t');
		boolean exp3 = (ch == 'x' || ch == 'X');
		boolean exp4 = '0' <= ch && ch <= '9';
		boolean exp5 = 
				('A' <= ch && ch <= 'Z') ||
				('a' <= ch && ch <= 'z');
		boolean exp6 = 
				(year % 400 == 0) ||
				(year % 4 == 0 && year % 100 != 0);
		boolean exp7 = !powerOn;
		boolean exp8 = str.equals("yes");

		System.out.println(exp1);
		System.out.println(exp2);
		System.out.println(exp3);
		System.out.println(exp4);
		System.out.println(exp5);
		System.out.println(exp6);
		System.out.println(exp7);
		System.out.println(exp8);
	}
	
}
