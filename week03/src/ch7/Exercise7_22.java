package ch7;

abstract class Shape {
	Point p;
	
	Shape() {
		this(new Point(0, 0));
	}
	
	Shape(Point p) {
		this.p = p;
	}
	
	// 도형의 면적을 계산해서 반환하는 메서드
	abstract double calcArea();
	
	Point getPosition() {
		return p;
	}
	
	void setPosition(Point p) {
		this.p = p;
	}
}

class Circle extends Shape {
	double r;
	
	Circle() {
		this(new Point(0, 0), 0);
	}
	
	Circle(Point p, double r) {
		super(p);
		this.r = r;
	}
	
	Circle(double r) {
		super();
		this.r = r;
	}
	
	double calcArea() {
		return Math.PI * r * r;
	}
}

class Rectangle extends Shape {
	double width;
	double height;
	
	Rectangle() {
		this(new Point(0, 0), 0, 0);
	}
	
	Rectangle(Point p, double width, double height) {
		super(p);
		this.width = width;
		this.height = height;
	}
	
	Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	double calcArea() {
		return width * height;
	}
	
	boolean isSqare() {
		return width == height && width * height != 0;
	}
}

class Point {
	int x;
	int y;
	
	Point() {
		this(0, 0);
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "["+x+", "+y+"]";
	}
}

class Exercise7_22 {

	public static void main(String[] args) {

	}

}
