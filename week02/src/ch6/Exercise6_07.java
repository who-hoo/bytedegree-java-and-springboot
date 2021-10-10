package ch6;

class MyPoint {
	int x;
	int y;
	
	MyPoint() {}
	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double getDistance(int x, int y) {
		return Math.sqrt(Math.pow(this.x-x, 2)+Math.pow(this.y-y, 2));
	}
}

class Exercise6_07 {

	public static void main(String[] args) {
		MyPoint p = new MyPoint(1, 1);
		
		// p와 (2, 2)의 거리를 구한다.
		System.out.println(p.getDistance(2, 2));
	}

}
