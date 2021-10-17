package ch7;

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		// 1 ~ 10까지의 숫자가 적힌 카드가 한 쌍씩 있고,
		// 숫자가 1, 3, 8인 경우에는 둘 중의 한 장은 광(Kwang)이어야 한다.
		for (int i=1, j=0; i<=10; i++) {
			cards[j++] = new SutdaCard(i, (i == 1 || i == 3 || i == 8) ? true : false);
			cards[j++] = new SutdaCard(i, false);
		}
	}
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString() {
		return num + ( isKwang ? "K" : "" );
	}
}

class Exercise7_01 {

	public static void main(String[] args) {
		SutdaDeck deck = new SutdaDeck();
		
		for (int i=0; i<deck.cards.length; i++) {
			System.out.print(deck.cards[i]+",");
		}
	}

}
