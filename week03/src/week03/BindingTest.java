package week03;

class BindingTest {

	public static void main(String[] args) {
		Parent p = new Child();
		Child  c = new Child();
		
		System.out.println("p.x = " +p.x);
		p.method();
		System.out.println();
		System.out.println("c.x = " +c.x);
		c.method();
	}

}

class Parent {
	int x = 100;
	
	void method() {
		System.out.println("i'm parent");
	}
}

class Child extends Parent {
	int x = 200;
	
	void method() {
		System.out.println("i'm child");
		System.out.println("x = " + x);
		System.out.println("super.x = " + super.x);
		System.out.println("this.x = " + this.x);
	}
}