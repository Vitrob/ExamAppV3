
import exam.Exam;
import login.LoginClass;
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
            Exam exam = new Exam(sessionFactory);
            LoginClass loginClass = new LoginClass(sessionFactory);

            userManager.deleteUsers(); //deleting old users
            questionManager.deleteQuestions(); //deleting old questions
            questionManager.addQuestions(); // adding 10 questions to database
            //List<Question> questions = questionManager.addQuestionsV2(); // getting all questions as list
            userManager.addUsers(); //adding new users to database
            //exam.getQuestions(); //getting all the data that is stored in databse for one user
            loginClass.loginFromListInJava(); //getting all the users and using stream() to check login values

        } catch (Exception e) {
            System.out.printf("Error: %s%n", e.getMessage());
        }


    }
}


