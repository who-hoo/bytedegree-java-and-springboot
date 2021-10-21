package week04;

import java.util.*;

class ExpValidChecker {
	static void isValid(String exp) {
		Stack<Character> validChecker = new Stack<>();
		
		try {
			for (int i = 0; i < exp.length(); i++) {
				char ch = exp.charAt(i);
				if (ch == '(') {
					validChecker.push('(');
				} else if (ch == ')') {
					validChecker.pop();
				}
			}
			
			if (validChecker.isEmpty()) {
				System.out.println("괄호가 일치합니다.");
				return;
			}
			System.out.println("괄호가 일치하지 않습니다 (.");
		} catch (EmptyStackException e) {
			System.out.println("괄호가 일치하지 않습니다 ).");
		}
	}
}

class StackEx2 {

	public static void main(String[] args) {
		String exp1 = "((1+2)/3)*10";
		String exp2 = "(((1+2)/3)*10";
		String exp3 = "((1+2)/3))*10";
		
		ExpValidChecker.isValid(exp1);
		ExpValidChecker.isValid(exp2);
		ExpValidChecker.isValid(exp3);
	}

}
