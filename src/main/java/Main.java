
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

            userManager.deleteUsers();
            questionManager.deleteQuestions();
            questionManager.addQuestions(); // adding 10 questions to database
            userManager.addUsers();
            System.out.println();


        } catch (Exception e) {
            System.out.printf("Error: %s%n", e.getMessage());
        }


    }
}


