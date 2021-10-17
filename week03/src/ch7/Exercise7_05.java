package ch7;

class Product {
	int price;
	int bonusPoint;
	
	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
}

class Tv extends Product {
	/*
	Tv() {
		// 기본생성자 Tv() 안에 내용이 구현되어 있지 않아, 컴파일러에 의해 첫줄에 super();가 자동 추가되는데,
		// 조상클래스 Product에 기본생성자 Product()가 정의되어 있지 않아, 에러 발생.
		// 조상클래스 Product에 기본생성자 Product()를 정의하거나, 기본생성자 Tv()에 내용을 구현하여 해결한다.
	}
	*/
	
	Tv() {
		super(1000000);
	}
	
	public String toString() {
		return "Tv";
	}
}

class Exercise7_05 {

	public static void main(String[] args) {
		Tv tv = new Tv();
	}

}
