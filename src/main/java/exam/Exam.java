package exam;

import managers.UserManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import tables.Question;
import tables.User;

import java.util.List;


public class Exam  {
    private final SessionFactory sessionFactory;

    public Exam(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void getQuestions(int userNumber) {
        UserManager userManager = new UserManager(sessionFactory);

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            System.out.println("------------------- USER  1--------------------------");
            User user1 = userManager.getOneUser(userNumber);
            System.out.println(user1);
            System.out.println("------------------- USER 2--------------------------");
            User user2 = userManager.getOneUser();
            System.out.println(user2);

            System.out.println("------------------ QUESTIONS --------------------------");
            List<Question> questions = user1.getQuestions();
            System.out.println(questions);
            System.out.println("------------------ QUESTION 1 BY 1 --------------------------");
            Question q = questions.get(1);
            System.out.println(q);
            System.out.println("------------------ TEXT --------------------------");
            System.out.println(q.getQuestionText());
            System.out.println("-------------------------------------------------------");



            session.getTransaction().commit();


        }


    }


}
