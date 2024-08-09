package Quiz;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which keyword is used to prevent inheritance of a class in Java?", List.of("abstract", "static", "private", "final"), 3));
        questions.add(new Question("What is the size of an int variable in Java?", List.of("8 bits", "16 bits", "32 bits", "64 bits"), 2));
        questions.add(new Question("Which of the following is used to create an instance of a class in Java?", List.of("instance", "new", "create", "class"), 1));
        questions.add(new Question("What is the purpose of the static keyword in Java?", List.of("To associate a method or variable with the class, rather than an instance", "To define a constant", "To create an instance variable", "To create a local variable"), 0));

        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int questionTimeLimit = 10;
        List<Boolean> results = new ArrayList<>();

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            for (int i = 0; i < question.getOptions().size(); i++) {
                System.out.println((i + 1) + ". " + question.getOptions().get(i));
            }

            QuizTimer quizTimer = new QuizTimer(questionTimeLimit);
            quizTimer.start();

            int userAnswer = -1;
            while (!quizTimer.isTimeUp()) {
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt() - 1;
                    break;
                }
            }

            quizTimer.stop();

            if (quizTimer.isTimeUp()) {
                System.out.println("You ran out of time for this question.");
                results.add(false);
            } else if (question.isCorrect(userAnswer)) {
                System.out.println("Correct Answer!");
                score+=10;
                results.add(true);
            } else {
                System.out.println("Wrong Answer!");
                results.add(false);
            }

            System.out.println();
        }

        System.out.println("Quiz completed! Your score: " + score + " out of " + questions.size()*10);
        if (score == 40) {
            System.out.println("You've got full points! \n :)");
        }
        else if (score == 0) {
            System.out.println("Good Luck Next Time \n :(");
        }
        System.out.println("\nSummary:");
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + question.getQuestionText());
            System.out.println("Your answer: " + (results.get(i) ? "Correct" : "Incorrect"));
            System.out.println("Correct answer: " + question.getOptions().get(question.getCorrectOption()));
            System.out.println();
        }
        scanner.close();
    }
}

