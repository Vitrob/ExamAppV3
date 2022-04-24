

import additionalFeatures.UserQuestionManager;
import managers.QuestionManager;
import managers.UserManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.Question;
import tables.User;


public class Main {
    public static void main(String[] args) {


        try (SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory()) {


            QuestionManager questionManager = new QuestionManager(sessionFactory);
            UserManager userManager = new UserManager(sessionFactory);
            UserQuestionManager userQuestionManager = new UserQuestionManager(sessionFactory);

            userManager.deleteUsers();
            questionManager.deleteQuestions();

            userManager.addUsers();
            System.out.println();
            System.out.println("ONE QUESTION:");
            System.out.println(questionManager.getOneQuestion());
            System.out.println("-----");

            System.out.println(userManager.getUsers());


            System.out.println(userManager.getUsers());
            System.out.println("Only one user: " + userManager.getOneUser());

            System.out.println(userQuestionManager.getQuestions());
        } catch (Exception e) {
            System.out.printf("Error: %s%n", e.getMessage());
        }


    }
}


