package exam;

import lombok.NonNull;
import managers.UserManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import tables.Question;
import tables.User;

import java.util.List;


public class Exam {
    private final SessionFactory sessionFactory;

    public Exam(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void getQuestions(int userNumber) {
        UserManager userManager = new UserManager(sessionFactory);

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            User user = userManager.getOneUser(userNumber);
            //    System.out.println(user); //getting all the data that is stored in the databse for one user

            List<Question> questions = user.getQuestions();
            @NonNull String questionText = questions.get(1).getQuestionText();
            @NonNull String correctAnswerText = questions.get(1).getCorrectAnswerText();
            @NonNull String wrongAnswerText1 = questions.get(1).getWrongAnswerText1();
            @NonNull String wrongAnswerText2 = questions.get(1).getWrongAnswerText2();
            @NonNull String wrongAnswerText3 = questions.get(1).getWrongAnswerText3();

            System.out.println("------------------ QUESTION 1--------------------------");
            System.out.println(questionText);
            System.out.println("-------------------------------------------------------");


            System.out.println("A: " + correctAnswerText);
            System.out.println("B: " + wrongAnswerText1);
            System.out.println("C: " + wrongAnswerText2);
            System.out.println("D: " + wrongAnswerText3);


            session.getTransaction().commit();


        }


    }


}
