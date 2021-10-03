package ch4;

class Exercise4_06 {

	public static void main(String[] args) {
		int count = 0;
		
		for(int dice1=1; dice1 <=6; dice1++) {
			for(int dice2=1; dice2 <=6; dice2++) {
				if (dice1 + dice2 == 6) {
					count += 1;
					System.out.println(count+"번째 경우 : "+dice1+"&"+dice2);
				}
			}
		}
	}

}
