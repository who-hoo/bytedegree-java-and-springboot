package week03;

class CastingTest {

	public static void main(String[] args) {
		Car car1 = null;
		Car car2 = new Car();
		FireEngine fe1 = new FireEngine();
		FireEngine fe2 = null;
		FireEngine fe3 = null;
		
		fe1.water();
		car1 = fe1;             // up-casting. FireEngine -> Car
		// car.water();         // The method water() is undefined for the type Car
		fe2 = (FireEngine)car1; // down-casting. Car -> FireEngine
		fe2.water();
		
		car2.drive();
		fe3 = (FireEngine)car2;
		// fe3.drive();         // Car cannot be cast to FireEngine
		
	}

}

class Car {
	String color;
	int door;
	
	void drive() {
		System.out.println("drive, Brrrr~");
	}
	
	void stop() {
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car {
	void water() {
		System.out.println("water!!!");
	}
}