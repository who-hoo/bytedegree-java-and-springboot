package ch7;

class Exercise7_15 {

	public static void main(String[] args) {
		/* 
		 * 클래스가 다음과 같이 정의되어 있을 때, 형변환을 올바르게 하지 않은 것은? (모두 고르시오)
		 * class Unit {}
		 * class AirUnit extends Unit {}
		 * class GroundUnit extends Unit {}
		 * class AirCraft extends AirUnit {}
		 * class Tank extends GroundUnit {}
		 * 
		 * Unit u = new GroundUnit();
		 * Tank t = new Tank();
		 * AirCraft ac = new AirCraft();
		 * 
		 * a. u = (Unit)ac;
		 * b. u = ac;
		 * c. GroudUnit gu = (GroundUnit)u;
		 * d. AirUnit au = ac;
		 * e. t = (Tank)u;
		 * f. GroundUnit gu = t;
		 * 
		 * =>  e
		 */ 
	}

}
