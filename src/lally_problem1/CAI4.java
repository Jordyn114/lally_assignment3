package lally_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
	
	Scanner scan = new Scanner(System.in);
	
	public void quiz() {
		int factor1, factor2, response, totalCorrect = 0, isCorrect = 0, difficulty, newSet;
		float score;
		do {
			totalCorrect = 0;
			difficulty = readDifficulty();
			for (int i = 0; i < 10; i++) {
				factor1 = generateQuestionArgument(difficulty);
				factor2 = generateQuestionArgument(difficulty);
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
	public int readDifficulty() {
		System.out.printf("Enter a difficulty level (1-4): ");
		int difficulty = scan.nextInt();
		return difficulty;
	}
	public int generateQuestionArgument(int difficulty) {
		SecureRandom random = new SecureRandom();
		switch (difficulty) {
		case 1 : return 1 + random.nextInt(9);
		case 2 : return 1 + random.nextInt(99);
		case 3 : return 1 + random.nextInt(999);
		case 4 : return 1 + random.nextInt(9999);
		default : return 0;
		}
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
		CAI4 app = new CAI4();
		app.quiz();
	}

}