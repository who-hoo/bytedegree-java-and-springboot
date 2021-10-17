package ch7;

class Parent {
	int x = 100;
	
	Parent() {
		this(200);
	}
	
	Parent(int x) {
		this.x = x;
	}
	
	int getX() {
		return x;
	}
}

class Child extends Parent {
	int x = 3000;
	
	Child() {
		this(1000);
	}
	
	Child(int x) {
		this.x = x;
	}
}

class Exercise7_07 {

	public static void main(String[] args) {
		Child c = new Child(); // Parent() -> Parent(int x) -> Child() -> Child(int x)
		
		System.out.println("x = " + c.getX()); // 200
	}

}
