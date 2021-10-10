package ch6;

class SutdaCard {
	int num = 1;
	boolean isKwang = true;
	
	SutdaCard() {}
	SutdaCard(int num, boolean isKwang) {
		if (!(1<=num && num <= 9)) {
			return;
		}
		this.num = num;
		this.isKwang = isKwang;
	}
	
	String info() {
		return num + (isKwang ? "K" : "");
	}
}

class Exercise6_02 {

	public static void main(String[] args) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info());
		System.out.println(card2.info());
	}

}
