package ch3;

class Exercise3_02 {

	public static void main(String[] args) {
		int numOfApples = 123; // 사과의 개수
		int sizeOfBuket = 10; // 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
		int answer = numOfApples/sizeOfBucket + (numOfApples % sizeOfBuket) > 0 ? 1 : 0);
		int numOfBucket = (answer); // 모든 사과를 담는데 필요힌 바구니의 수
		
		System.out.println("필요한 바구니의 수 : " + numOfBucket); // 13
	}

}
