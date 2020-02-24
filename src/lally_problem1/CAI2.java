package lally_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	
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
		SecureRandom random = new SecureRandom();
		int rand = 1 + random.nextInt(4);
		switch (rand) {
			case 1 : System.out.printf("Very good!"); break;
			case 2 : System.out.printf("Excellent!"); break;
			case 3 : System.out.printf("Nice work!"); break;
			case 4 : System.out.printf("Keep up the good work!"); break;
		}
		System.exit(0);
	}
	public void displayIncorrectResponse() {
		SecureRandom random = new SecureRandom();
		int rand = 1 + random.nextInt(4);
		switch (rand) {
			case 1 : System.out.printf("No. Please try again. "); break;
			case 2 : System.out.printf("Wrong. Try once more. "); break;
			case 3 : System.out.printf("Don't give up! "); break;
			case 4 : System.out.printf("No. Keep trying. "); break;
		}
	}

	public static void main(String[] args) {
		CAI2 app = new CAI2();
		app.quiz();
	}

}