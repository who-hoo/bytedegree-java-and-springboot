package week04;

import java.util.Stack;

class StackEx1 {
	static Stack<String> back = new Stack<>();
	static Stack<String> forward = new Stack<>();
	
	static void printStatus() {
		System.out.println("back : " + back);
		System.out.println("forward : " + forward);
		System.out.println("current : " + back.peek());
		System.out.println();
	}
	
	static void goURL(String url) {
		back.push(url);
		if(!forward.empty())
			forward.clear();
	}
	
	static void goForward() {
		if(!forward.empty())
			back.push(forward.pop());
	}
	
	static void goBack() {
		if(!back.empty())
			forward.push(back.pop());
	}

	public static void main(String[] args) {
		goURL("1. naver");
		goURL("2. daum");
		goURL("3. google");
		goURL("4. stackoverflow");
		
		printStatus();
		
		goBack();
		System.out.println("go back");
		printStatus();
		
		goBack();
		System.out.println("go back");
		printStatus();
		
		goForward();
		System.out.println("go forward");
		printStatus();
		
		goURL("who-hoo.github.io");
		System.out.println("go new url");
		printStatus();
	}

}
