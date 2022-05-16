package login;

import exam.Exam;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tables.User;

import java.util.List;
import java.util.Scanner;

public class LoginClass {

    private final SessionFactory sessionFactory;

    public LoginClass(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void loginFromListInJava() {

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("---------------------WELCOME TO OUR EXAM APPLICATION-------------------------------");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);

        boolean validate;

        String answerName;
        String answerPassword;

        do {
            System.out.println("------------------------------------FIRST STEP------------------------------------------");
            System.out.print("Please enter your name: ");
            answerName = input.nextLine();
            String finalNameAnswer = answerName;

            validate = getUsers().stream()
                    .noneMatch(user -> user.getUserName().equals(finalNameAnswer));
            System.out.println("Wrong name, please enter your name again");
            System.out.println("Remember - it is case sensitive");

        } while (validate);

        System.out.println("CORRECT NAME!");

        do {
            System.out.println("------------------------------------SECOND STEP-----------------------------------------");
            System.out.print("Please enter your password: ");
            answerPassword = input.nextLine();
            String finalPasswordAnswer = answerPassword;

            String finalNameAnser = answerName;
            validate = getUsers().stream()
                    .filter(user -> user.getUserName().equals(finalNameAnser))
                    .noneMatch(user -> user.getPassword().equals(finalPasswordAnswer));
            System.out.println("Wrong password, please enter your password again");
            System.out.println("Remember - it is case sensitive");

        } while (validate);

        System.out.println("CORRECT PASSWORD!");

        Exam exam = new Exam(sessionFactory);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Query<User> query = session
                    .createQuery("FROM User WHERE user_name = :un"
                            , User.class)
                    .setParameter("un"
                            , answerName);
            User user = query.uniqueResult();

            session.getTransaction().commit();
            int idNumber = user.getIdNumber();
            exam.getQuestions(idNumber);
        }
    }

    public List<User> getUsers() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<User> users = session.createQuery("FROM User", User.class).list();
            //             users.forEach(System.out::println);
            session.getTransaction().commit();
            return users;
        }
    }


    public void loginFromDatabase() {

    }
}


