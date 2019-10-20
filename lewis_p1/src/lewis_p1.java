import java.util.Scanner;
import java.security.SecureRandom;

public class lewis_p1 {

    //Main method
    public static void main(String[] args) {
        int i = 0;
        Scanner scnr = new Scanner(System.in);

        String startAgain = "yes";
        while(startAgain.equals("yes") || startAgain.equals("Yes")) {

            System.out.println("\nNew Session:");

            int numCorrectAnswers = 0;

            int levelAnswer = determineLevel();

            int questionType = determineArithmetic();

            numCorrectAnswers = createQuestion(levelAnswer, questionType);

            int percentCorrect = numCorrectAnswers * 100 / 10;

            if (percentCorrect >= 75) {
                System.out.println("Congratulations, you are ready to go to the next level!\nYour Score: " + percentCorrect + "%\n");
            } else {
                System.out.println("Please ask your teacher for extra help.\nYour Score: " + percentCorrect + "%\n");
            }
            System.out.println("Start a new session? (yes / no)");
            startAgain = scnr.next();

        }
        System.out.println("\nGoodbye!");
    }

    //Ask user what level they want to play at
    public static int determineLevel() {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please choose a difficulty level:");
        System.out.println("\t1 - 1 digit numbers");
        System.out.println("\t2 - 2 digit numbers");
        System.out.println("\t3 - 3 digit numbers");
        System.out.println("\t4 - 4 digit numbers");
        int levelAnswer = scnr.nextInt();

        return levelAnswer;
    }

    //Ask user what kind of questions they want to answer
    public static int determineArithmetic() {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Please choose what kind of question you would like to answer:");
        System.out.println("\t1 - Addition");
        System.out.println("\t2 - Multiplication");
        System.out.println("\t3 - Subtraction");
        System.out.println("\t4 - Division");
        System.out.println("\t5 - Random Mix");
        int questionTypeAnswer = scnr.nextInt();

        return questionTypeAnswer;
    }

    //Create questions for user
    public static int createQuestion(int whatLevel, int whatQuestion) {
        Scanner scnr = new Scanner(System.in);
        SecureRandom rand = new SecureRandom();

        int i = 0;
        int numCorrect = 0;
        int numWrong = 0;

        for (i = 0; i < 10; ++i) {

            int rand1 = 0;
            int rand2 = 0;

            //Based on specified level
            if(whatLevel == 1) {
                rand1 = rand.nextInt(9) + 1;
                rand2 = rand.nextInt(9) + 1;
            }

            else if(whatLevel == 2) {
                rand1 = rand.nextInt(90) + 10;
                rand2 = rand.nextInt(90) + 10;
            }

            else if(whatLevel == 3) {
                rand1 = rand.nextInt(900) + 100;
                rand2 = rand.nextInt(900) + 100;
            }

            else if(whatLevel == 4) {
                rand1 = rand.nextInt(9000) + 1000;
                rand2 = rand.nextInt(9000) + 1000;
            }

            double correctAnswer = 0;
            double userInput = 0;

            //Based on type of question
            if(whatQuestion == 1) {
                correctAnswer = rand1 + rand2;
                System.out.println("How much is " + rand1 + " + " + rand2 + "?");
                userInput = scnr.nextDouble();
            }

            if(whatQuestion == 2) {
                correctAnswer = rand1 * rand2;
                System.out.println("How much is " + rand1 + " * " + rand2 + "?");
                userInput = scnr.nextDouble();
            }

            if(whatQuestion == 3) {
                correctAnswer = rand1 - rand2;
                System.out.println("How much is " + rand1 + " - " + rand2 + "?");
                userInput = scnr.nextInt();
            }

            if(whatQuestion == 4) {
                correctAnswer = 1.0 * rand1 / rand2;
                System.out.println("How much is " + rand1 + " / " + rand2 + "?");
                userInput = scnr.nextDouble();
            }

            if(whatQuestion == 5) {
                int randQuestionType = rand.nextInt(4)+1;
                if(randQuestionType == 1) {
                    correctAnswer = rand1 + rand2;
                    System.out.println("How much is " + rand1 + " + " + rand2 + "?");
                    userInput = scnr.nextDouble();
                }

                if(randQuestionType == 2) {
                    correctAnswer = rand1 * rand2;
                    System.out.println("How much is " + rand1 + " * " + rand2 + "?");
                    userInput = scnr.nextDouble();
                }

                if(randQuestionType == 3) {
                    correctAnswer = rand1 - rand2;
                    System.out.println("How much is " + rand1 + " - " + rand2 + "?");
                    userInput = scnr.nextDouble();
                }

                if(randQuestionType == 4) {
                    correctAnswer = rand1 / rand2;
                    System.out.println("How much is " + rand1 + " / " + rand2 + "?");
                    userInput = scnr.nextDouble();
                }
            }

            if (Math.abs(correctAnswer - userInput) > .001) {
                generateResponseToQuestion(0);
                ++numWrong;
            }
            else {
                generateResponseToQuestion(1);
                ++numCorrect;
            }

        }
        System.out.println("You got " + numCorrect + " questions correct.");
        System.out.println("You got " + numWrong + " questions incorrect.");

        return numCorrect;
    }

    //Generate response based on correctness
    public static void generateResponseToQuestion(int correctOrWrong) {
        SecureRandom rand = new SecureRandom();

        String[] correctOptions = {"Very good!", "Excellent!", "Nice work!", "Keep up the good work!"};
        String[] incorrectOptions = {"No. Please try again.", "Wrong. Try once more.", "Don't give up!", "No. Keep trying."};

        int randResponse = rand.nextInt(4);

        if(correctOrWrong == 0) {
            switch (randResponse) {
                case 0:
                    System.out.println(incorrectOptions[0]);
                    break;
                case 1:
                    System.out.println(incorrectOptions[1]);
                    break;
                case 2:
                    System.out.println(incorrectOptions[2]);
                    break;
                case 3:
                    System.out.println(incorrectOptions[3]);
                    break;
            }
        }

        if(correctOrWrong == 1) {
            switch (randResponse) {
                case 0:
                    System.out.println(correctOptions[0]);
                    break;
                case 1:
                    System.out.println(correctOptions[1]);
                    break;
                case 2:
                    System.out.println(correctOptions[2]);
                    break;
                case 3:
                    System.out.println(correctOptions[3]);
                    break;
            }
        }
        return;
    }
}