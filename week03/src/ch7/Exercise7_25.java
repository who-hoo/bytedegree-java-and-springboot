package ch7;

class Outer {
	class Inner {
		int iv = 100;
	}
}

class Exercise7_25 {

	public static void main(String[] args) {
		System.out.println(new Outer().new Inner().iv);
	}

}
