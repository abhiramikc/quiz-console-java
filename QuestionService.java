import java.util.Scanner;

public class QuestionService {
    Question[] question = new Question[5];
    String answer[] = new String[5];

    public QuestionService() {
        question[0] = new Question(1, "which one is the most popular ?", "java", "python", "c++", "html", "java");
        question[1] = new Question(2, "which one is the most used in google?", "java", "python", "c++", "html", "java");
        question[2] = new Question(3, "which one is the name of india?", "bharat", "hindustan", "india", "hindustan",
                "bharat");
        question[3] = new Question(4, "which one is the capital of india ?", "mumbai", "delhi", "bangalore", "chennai",
                "delhi");
        question[4] = new Question(5, "which one is the currency of india ?", "dollar", "euro", "rupee", "pound",
                "rupee");
    }

    public void playQuiz() {
        int i = 0;
        Scanner sc = new Scanner(System.in);
        for (Question q : question) {
            System.out.println("Question Number: " + q.getId());
            System.out.println(q.getQuestion());
            System.out.println("1. " + q.getOpt1());
            System.out.println("2. " + q.getOpt2());
            System.out.println("3. " + q.getOpt3());
            System.out.println("4. " + q.getOpt4());
            System.out.println("Enter your answer");
            answer[i] = sc.nextLine();
            i++;
        }

        System.out.println("\nYour Answers:");
        for (int j = 0; j < question.length; j++) {
            System.out.println("Question " + question[j].getId() + ": " + answer[j]);
        }
    }

    public void printScore() {
        int score = 0;
        for (int i = 0; i < question.length; i++) {
            Question que = question[i];
            String actualAnswer = que.getAnswer();
            String userAnswer = answer[i] != null ? answer[i].trim() : "";

            // Support entering either option number (1, 2, 3, 4) or actual text
            String selectedText = userAnswer;
            if (userAnswer.equals("1")) selectedText = que.getOpt1();
            else if (userAnswer.equals("2")) selectedText = que.getOpt2();
            else if (userAnswer.equals("3")) selectedText = que.getOpt3();
            else if (userAnswer.equals("4")) selectedText = que.getOpt4();

            if (actualAnswer.equalsIgnoreCase(selectedText)) {
                score++;
            }
        }
        System.out.println("\nScore: " + score + " / " + question.length);
    }
}
