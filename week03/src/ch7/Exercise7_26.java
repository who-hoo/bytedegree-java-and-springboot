package ch7;

class Outer2 {
	static class Inner2 {
		int iv = 200;
	}
}

public class Exercise7_26 {

	public static void main(String[] args) {
		System.out.println(new Outer2.Inner2().iv);
	}

}
