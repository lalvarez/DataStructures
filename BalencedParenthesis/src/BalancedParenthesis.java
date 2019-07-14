import java.util.Scanner;

public class BalancedParenthesis {

	// This class implements the exercise of the second week

	// Methods

	public static boolean isBalanced(SStack stack, String expresion, char[] expresionArr) {

		for (int i = 0; i < expresionArr.length; i++) {
			
		//First the programme check the first char
			//If the char isn't a tipe of parenthesis , it will be ignored
			if (expresionArr[i] == '(' || expresionArr[i] == '{' || expresionArr[i] == '[') {
				// When the char is a starter parenthesis it is pushed into the stack 
				
				stack.push(expresionArr[i]);
				
				

			}
			
			
			else if (expresionArr[i] == ')' || expresionArr[i] == '}' || expresionArr[i] == ']') {
				// if char == ),},] and the peak is their equivalent parenthesis (,{,[ it will be eliminated from the stack
				
				char last = (char)(stack.top().elem);
				
				if (expresionArr[i] == ')' && last == '(') {
					
					 stack.pop();

				}
				if (expresionArr[i] == '}' && last == '{') {

					stack.pop();

				}
				if (expresionArr[i] == ']' && last == '[') {

					stack.pop();
				}
			}
		}

		// if the parenthesis are balanced , the stack must be empty
		
		return stack.isEmpty();

	}

	public static void main(String[] args) throws InterruptedException  {

		System.out.println("Introduce the expresion: ");
		
		//The user introduces an expresion
		Scanner read = new Scanner(System.in);
		String expresion = read.nextLine();

		//The programme makes a char array of the expresion 
		char[] expresionArr = expresion.toCharArray();

		
		// Create the stack 
		SStack stack = new SStack();
		
		//Results
		
		//The method isBalanced is called and it returns a boolean expresion 
		if (isBalanced(stack, expresion, expresionArr)){
			System.out.println("The computer is checking if it is correct, please wait a minute...");
			Thread.sleep(2000);
			System.out.println("The expresion is correct");
		}
		
		if (!isBalanced(stack, expresion, expresionArr)){
			System.out.println("The computer is checking if it is correct, please wait a minute...");
			
			Thread.sleep(2000);
			System.out.println("The expresion isn't correct");
		}
	}

}
