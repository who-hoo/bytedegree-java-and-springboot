package ch3;

class Exercise3_07 {

	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = 5/9f * (fahrenheit - 32); // 37.77778
		// TODO : Math.round()를 사용하지 않고 celcius 소수점 셋째자리에서 반올림하기
		
		System.out.println("Fahrenheit: " + fahrenheit); // 100
		System.out.println("Celcius: " + celcius); // 37.78
	}

}
