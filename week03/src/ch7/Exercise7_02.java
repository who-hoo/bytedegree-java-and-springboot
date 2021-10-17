package ch7;

class SutdaDeck2 {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck2() {
		// 1 ~ 10까지의 숫자가 적힌 카드가 한 쌍씩 있고,
		// 숫자가 1, 3, 8인 경우에는 둘 중의 한 장은 광(Kwang)이어야 한다.
		for (int i=1, j=0; i<=10; i++) {
			cards[j++] = new SutdaCard(i, (i == 1 || i == 3 || i == 8) ? true : false);
			cards[j++] = new SutdaCard(i, false);
		}
	}
	
	// 배열 cards에 담긴 카드의 위치를 뒤섞는다. (Math.random() 사용)
	void shuffle() {
		int randomInt;
		SutdaCard tempCard;
		
		for (int i=0; i<cards.length; i++) {
			randomInt = (int)(Math.random()*CARD_NUM);
			tempCard = cards[i];
			cards[i] = cards[randomInt];
			cards[randomInt] = tempCard;
		}
	}
	
	// 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
	SutdaCard pick(int index) {
		if (index < 0 || index >= CARD_NUM) return null; // index validation check
		return cards[index];
	}
	
	// 배열 cards에서 임의의 위치의 SutdaCard를 반한다. (Math.random() 사용)
	SutdaCard pick() {
		return cards[(int)(Math.random()*CARD_NUM)];
	}
}

class Exercise7_02 {

	public static void main(String[] args) {
		SutdaDeck2 deck = new SutdaDeck2();
		
		System.out.println(deck.pick(0));
		System.out.println(deck.pick());
		deck.shuffle();
		
		for (int i=0; i<deck.cards.length; i++) {
			System.out.print(deck.cards[i]+",");
		}
		
		System.out.println();
		System.out.println(deck.pick(0));
	}

}
