package ch6;

class Marine {
	int x=0, y=0;          // Marine의 위치좌표
	int hp = 60;           // 현재 체력
	// 모든 병사의 공격력과 방어력은 같아야 하기 때문에
	static int weapon = 6; // 공격력
	static int armor = 0;  // 방어력
	
	static void weaponUp() {
		weapon++;
	}
	
	static void armorUp() {
		armor++;
	}
	
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Exercise6_09 {

	public static void main(String[] args) {

	}

}
