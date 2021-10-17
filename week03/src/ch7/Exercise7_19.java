package ch7;

import java.util.Arrays;

class Buyer {
	int money = 1000;
	Product2[] cart = new Product2[3];
	int i=0;
	
	void buy(Product2 p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여 " + p + "을/를 살 수 없습니다.");
			return;
		}
		money -= p.price;
		add(p);
	}
	
	void add(Product2 p) {
		if (i >= cart.length) {
			Product2[] newCart = new Product2[cart.length*2];
			newCart = Arrays.copyOf(cart, newCart.length);
			cart = newCart;
		}
		cart[i++] = p;
	}
	
	void summary() {
		String list = "";
		int total = 0;
		
		for (Product2 product: cart) {
			list += (product + ", ");
			total += product.price;
		}
		
		System.out.println("구입한 물건:" + list);
		System.out.println("사용한 금액:" + total);
		System.out.println("남은 금액:" + money);
	}
}

class Product2 {
	int price;
	
	Product2(int price) {
		this.price = price;
	}
}

class Tv2 extends Product2 {
	Tv2() { super(100); }
	
	public String toString() { return "Tv"; }
}

class Computer extends Product2 {
	Computer() { super(200); }
	
	public String toString() { return "Computer"; }
}

class Audio extends Product2 {
	Audio() { super(50); }
	
	public String toString() { return "Audio"; }
}

class Exercise7_19 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv2());
		b.buy(new Computer());
		b.buy(new Tv2());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	}

}
