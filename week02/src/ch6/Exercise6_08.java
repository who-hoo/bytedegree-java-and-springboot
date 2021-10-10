package ch6;

class PlayingCard {
	int kind;
	int num;
	
	static int width;
	static int height;
	
	PlayingCard(int k, int n) {
		kind = k;
		num = n;
	}
}

class Exercise6_08 {

	public static void main(String[] args) {
		PlayingCard card = new PlayingCard(1, 1);
		
		System.out.println("클래스변수 : width, height");
		System.out.println("인스턴스변수 : kind, num");
		System.out.println("지역변수 : k, n, args[], card");
	}

}
