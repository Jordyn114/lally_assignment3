package lally_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	
	Scanner scan = new Scanner(System.in);
	
	public void quiz() {
		SecureRandom random = new SecureRandom();
		int factor1, factor2, response, totalCorrect = 0, isCorrect = 0, difficulty, problemType, matchProblemType, newSet;
		float score;
		do {
			totalCorrect = 0;
			problemType = readProblemType();
			difficulty = readDifficulty();
			for (int i = 0; i < 10; i++) {
				factor1 = generateQuestionArgument(difficulty);
				factor2 = generateQuestionArgument(difficulty);
				if (problemType == 5) {
					problemType = 1 + random.nextInt(4);
					matchProblemType = askQuestion(factor1, factor2, problemType);
					problemType = 5;
				}
				else
					matchProblemType = askQuestion(factor1, factor2, problemType);
				response = readResponse();
				isCorrect = isAnswerCorrect(response, factor1, factor2, matchProblemType);
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
	public int readProblemType() {
		System.out.printf("1 - Addition\n"
						+ "2 - Multiplication\n"
						+ "3 - Subtraction\n"
						+ "4 - Division\n"
						+ "5 - Random Arithmetic\n"
						+ "Choose a problem type to work on (1-5): ");
		int problemType = scan.nextInt();
		return problemType;
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
	public int askQuestion(int factor1, int factor2, int problemType) {
		switch (problemType) {
			case 1 : System.out.printf("How much is %d plus %d? ", factor1, factor2); return 1;
			case 2 : System.out.printf("How much is %d times %d? ", factor1, factor2); return 2;
			case 3 : System.out.printf("How much is %d minus %d? ", factor1, factor2); return 3;
			case 4 : System.out.printf("How much is %d divided by %d? ", factor1, factor2); return 4;
			default : return 0;
		}
	}
	public int readResponse() {
		int response = scan.nextInt();
		return response;
	}
	public int isAnswerCorrect(int response, int factor1, int factor2, int matchProblemType) {
		switch (matchProblemType) {
		case 1 :
			if (response == factor1 + factor2)
				return 1;
			else return 0;
		case 2 :
			if (response == factor1 * factor2)
				return 1;
			else return 0;
		case 3 :
			if (response == factor1 - factor2)
				return 1;
			else return 0;
		case 4 :
			if (response == factor1 / factor2)
				return 1;
			else return 0;
		default : return 0;
		}
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
		System.out.printf("\nYour score is %.2f.\n", score * 100);
		if (score < 0.75)
			System.out.printf("Please ask your teacher for extra help.\n\n");
		else
			System.out.printf("Congratulations, you are ready to go to the next level!\n\n");
	}

	public static void main(String[] args) {
		CAI5 app = new CAI5();
		app.quiz();
	}

}