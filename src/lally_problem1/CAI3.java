package lally_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	
	Scanner scan = new Scanner(System.in);
	
	public void quiz() {
		SecureRandom random = new SecureRandom();
		int factor1, factor2, response, totalCorrect, isCorrect = 0, newSet;
		float score;
		do {
			totalCorrect = 0;
			for (int i = 0; i < 10; i++) {
				factor1 = 1 + random.nextInt(9);
				factor2 = 1 + random.nextInt(9);
				askQuestion(factor1, factor2);
				response = readResponse();
				isCorrect = isAnswerCorrect(response, factor1, factor2);
				if (isCorrect == 1) {
					displayCorrectResponse();
					totalCorrect++;
				}
				else
					displayIncorrectResponse();
			}
			score = totalCorrect / 10f;
			displayCompletionMessage(score);
			System.out.printf("Would you like to do another problem set? Enter 1 for yes and 0 for no: ");
			newSet = scan.nextInt();
		} while (newSet == 1);
		System.out.printf("Goodbye!");
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
			case 1 : System.out.printf("Very good!\n"); break;
			case 2 : System.out.printf("Excellent!\n"); break;
			case 3 : System.out.printf("Nice work!\n"); break;
			case 4 : System.out.printf("Keep up the good work!\n"); break;
		}
	}
	public void displayIncorrectResponse() {
		SecureRandom random = new SecureRandom();
		int rand = 1 + random.nextInt(4);
		switch (rand) {
			case 1 : System.out.printf("No. Please try again.\n"); break;
			case 2 : System.out.printf("Wrong. Try once more.\n"); break;
			case 3 : System.out.printf("Don't give up!\n"); break;
			case 4 : System.out.printf("No. Keep trying.\n"); break;
		}
	}
	public void displayCompletionMessage(float score) {
		System.out.printf("\nYour score is %.2f.\n", score);
		if (score < 0.75)
			System.out.printf("Please ask your teacher for extra help.\n\n");
		else
			System.out.printf("Congratulations, you are ready to go to the next level!\n\n");
	}

	public static void main(String[] args) {
		CAI3 app = new CAI3();
		app.quiz();
	}

}