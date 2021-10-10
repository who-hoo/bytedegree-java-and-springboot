package ch6;

class MemberCall {
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
	// static int cv2 = iv; // 클래스 변수가 인스턴스 변수를 참조
	
	static void staticMethod1() {
		System.out.println(cv);
		// System.out.println(iv); // 스태틱 메서드가 인스턴스 변수를 참조
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);
	}
	
	static void staticMethod2() {
		staticMethod1();
		// instanceMethod1(); // 스태틱 메서드가 인스턴스 메서드 호출
	}
	
	void instanceMethod2() {
		staticMethod1();
		instanceMethod1();
	}
}

class Exercise6_18 {

	public static void main(String[] args) {

	}

}
