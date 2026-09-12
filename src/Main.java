import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("     QUIZMASTER");
        System.out.println("--------------------");
        System.out.println("Welcome to QuizMaster!");
        System.out.println("Let's test your general knowledge!\n");
        Question[] qns = QuestionBank.getQuestions();
        java.util.ArrayList<Question> rem =
                new java.util.ArrayList<>(java.util.Arrays.asList(qns));
        while (true) {
            int score=0;
            if (rem.size()<10) {
                System.out.println("\nAll questions have been used!");
                System.out.println("Starting a new round...");
                rem = new java.util.ArrayList<>(
                        java.util.Arrays.asList(qns)
                );
            }
            for (int i=0;i<10;i++) {
                int randomIndex=(int)(Math.random()*rem.size());
                Question curr=rem.remove(randomIndex);
                System.out.println("\nQuestion "+(i+1)+":");
                System.out.println(curr.question);
                for (int j=0;j<curr.options.length;j++) {
                    System.out.println((char)('A'+j) + ". " + curr.options[j]);
                }
                System.out.print("Your answer: ");
                String ans=sc.nextLine();
                int selectedAnswer =
                        ans.toUpperCase().charAt(0) - 'A';
                if (selectedAnswer==curr.correctAnswer) {
                    System.out.println("Correct! ✓");
                    score++;
                } else {
                    System.out.println("Wrong! ✗");
                    System.out.println("Correct answer: "
                            + (char)('A' + curr.correctAnswer)
                            + ". "
                            + curr.options[curr.correctAnswer]);
                }
            }
            System.out.println("\n----- QUIZ COMPLETED -----");
            System.out.println("Your Score: " + score + "/10");
            if (score>=8) {
                System.out.println("Excellent!");
            } else if (score>=5) {
                System.out.println("Good job!");
            } else {
                System.out.println("Keep practicing!");
            }
            System.out.print("\nDo you want to play again? (Y/N): ");
            String playAgain=sc.nextLine();
            if (playAgain.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
}