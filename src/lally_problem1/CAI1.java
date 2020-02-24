package lally_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	
	Scanner scan = new Scanner(System.in);
	
	public void quiz() {
		SecureRandom random = new SecureRandom();
		int factor1 = 1 + random.nextInt(9);
		int factor2 = 1 + random.nextInt(9);
		int isCorrect = 0;
		askQuestion(factor1, factor2);
		do {
			int response = readResponse();
			isCorrect = isAnswerCorrect(response, factor1, factor2);
			if (isCorrect == 1)
				displayCorrectResponse();
			else
				displayIncorrectResponse();
		} while (isCorrect == 0);
		
	}
	public void askQuestion(int factor1, int factor2) {
		System.out.printf("How much is %d times %d? ", factor1, factor2);
	}
	public int readResponse() {
		int response = scan.nextInt();
		return response;
	}
	public int isAnswerCorrect(int response, int factor1, int factor2) {
		if (response == factor1 * factor2)
			return 1;
		else return 0;
	}
	public void displayCorrectResponse() {
		System.out.printf("Very good!");
		System.exit(0);
	}
	public void displayIncorrectResponse() {
		System.out.printf("No. Please try again: ");
	}

	public static void main(String[] args) {
		CAI1 app = new CAI1();
		app.quiz();
	}

}
