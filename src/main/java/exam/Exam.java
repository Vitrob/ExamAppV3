package exam;

import lombok.NonNull;
import managers.UserManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import tables.Question;
import tables.User;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Exam {

    private final SessionFactory sessionFactory;

    public Exam(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private int score = 0;
    private int iterator = 0;


    public void getQuestions(int userNumber) {
        UserManager userManager = new UserManager(sessionFactory);


        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = userManager.getOneUser(userNumber);
            //  nextQuestion(user); //an additional mathod to use iterator to get next questions - in progress
            //    System.out.println(user); //getting all the data that is stored in the database for one user

            List<Question> questions = user.getQuestions();
            @NonNull String questionText = questions.get(0).getQuestionText();
            @NonNull String correctAnswerText = questions.get(0).getCorrectAnswerText();
            @NonNull String wrongAnswerText1 = questions.get(0).getWrongAnswerText1();
            @NonNull String wrongAnswerText2 = questions.get(0).getWrongAnswerText2();
            @NonNull String wrongAnswerText3 = questions.get(0).getWrongAnswerText3();

            System.out.println("------------------ QUESTION 1--------------------------");
            System.out.println(questionText);
            System.out.println("-------------------------------------------------------");

            countAnserws(correctAnswerText, wrongAnswerText1,
                    wrongAnswerText2, wrongAnswerText3, "A");


            questionText = questions.get(1).getQuestionText();
            correctAnswerText = questions.get(1).getCorrectAnswerText();
            wrongAnswerText1 = questions.get(1).getWrongAnswerText1();
            wrongAnswerText2 = questions.get(1).getWrongAnswerText2();
            wrongAnswerText3 = questions.get(1).getWrongAnswerText3();

            System.out.println("------------------ QUESTION 2--------------------------");
            System.out.println(questionText);
            System.out.println("-------------------------------------------------------");

            countAnserws(wrongAnswerText1,
                    wrongAnswerText2, wrongAnswerText3, correctAnswerText, "D");

            questionText = questions.get(2).getQuestionText();
            correctAnswerText = questions.get(2).getCorrectAnswerText();
            wrongAnswerText1 = questions.get(2).getWrongAnswerText1();
            wrongAnswerText2 = questions.get(2).getWrongAnswerText2();
            wrongAnswerText3 = questions.get(2).getWrongAnswerText3();

            System.out.println("------------------ QUESTION 3--------------------------");
            System.out.println(questionText);
            System.out.println("-------------------------------------------------------");

            countAnserws(wrongAnswerText1,
                    wrongAnswerText2, correctAnswerText, wrongAnswerText3, "C");

            questionText = questions.get(3).getQuestionText();
            correctAnswerText = questions.get(3).getCorrectAnswerText();
            wrongAnswerText1 = questions.get(3).getWrongAnswerText1();
            wrongAnswerText2 = questions.get(3).getWrongAnswerText2();
            wrongAnswerText3 = questions.get(3).getWrongAnswerText3();

            System.out.println("------------------ QUESTION 4--------------------------");
            System.out.println(questionText);
            System.out.println("-------------------------------------------------------");

            countAnserws(wrongAnswerText1,
                    wrongAnswerText2, correctAnswerText, wrongAnswerText3, "C");

            questionText = questions.get(4).getQuestionText();
            correctAnswerText = questions.get(4).getCorrectAnswerText();
            wrongAnswerText1 = questions.get(4).getWrongAnswerText1();
            wrongAnswerText2 = questions.get(4).getWrongAnswerText2();
            wrongAnswerText3 = questions.get(4).getWrongAnswerText3();

            System.out.println("------------------ QUESTION 5--------------------------");
            System.out.println(questionText);
            System.out.println("-------------------------------------------------------");

            countAnserws(wrongAnswerText1,
                    correctAnswerText, wrongAnswerText2, wrongAnswerText3, "B");


            session.getTransaction().commit();

            System.out.println("------------------- THE END ---------------------------");
            System.out.println("Your total score: " + score + "/5");
            System.out.println("-------------------------------------------------------");
        }


    }

    //when using this method please insert correct and wrong answers in some random order and then insert a correct character
    public void countAnserws(String answer1, String answer2, String answer3, String answer4, String correctAnswer) {
        String answer;
        boolean validate;
        Scanner input = new Scanner(System.in);
        List<String> list = List.of("A", "B", "C", "D");

        System.out.println("A: " + answer1);
        System.out.println("B: " + answer2);
        System.out.println("C: " + answer3);
        System.out.println("D: " + answer4);
        System.out.println("-------------------------------------------------------");

        do {
            System.out.print("Your answer: ");
            answer = input.nextLine();
            String finalAnswer = answer;
            validate = (!answer.equals(list.stream()
                    .filter(i -> i.equals(finalAnswer))
                    .collect(Collectors.joining())));

            if (answer.equals(correctAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong answer!");
            }

            System.out.println("Your score: " + score);
        } while (validate);

    }

    public List<String> nextQuestion(User user) {


        List<Question> questions = user.getQuestions();
        @NonNull String questionText = questions.get(iterator).getQuestionText();
        @NonNull String correctAnswerText = questions.get(iterator).getCorrectAnswerText();
        @NonNull String wrongAnswerText1 = questions.get(iterator).getWrongAnswerText1();
        @NonNull String wrongAnswerText2 = questions.get(iterator).getWrongAnswerText2();
        @NonNull String wrongAnswerText3 = questions.get(iterator).getWrongAnswerText3();


        iterator++;
        return List.of(questionText, correctAnswerText, wrongAnswerText1, wrongAnswerText2, wrongAnswerText3);
    }
}
