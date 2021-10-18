package week04;

class Point implements Cloneable {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	
	public Point clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {}
		return (Point)obj;
	}
}

class CloneEx {

	public static void main(String[] args) {
		Point original = new Point(3, 5);
		Point copy = original.clone();
		System.out.println(original);
		System.out.println(copy);
	}

}
