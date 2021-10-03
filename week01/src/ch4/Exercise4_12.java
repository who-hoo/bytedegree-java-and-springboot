package ch4;

class Exercise4_12 {

	public static void main(String[] args) {
		for (int i=2; i<=8; i+=3) {
			for (int j=1; j<=3; j++) {
				for (int k=i; k<=9 && k<i+3; k++) {
					System.out.print(k+"*"+j+"="+k*j+"\t");
				}
				System.out.println();
			}
			System.out.println();
		}		
	}

}
