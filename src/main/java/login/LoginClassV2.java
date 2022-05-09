package login;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tables.User;

import java.util.List;
import java.util.Scanner;

public class LoginClassV2 {

    private final SessionFactory sessionFactory;

    public LoginClassV2(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void loginFromListInJava() {

        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("---------------------WELCOME TO VITROB'S EXAM APPLICATION-------------------------------");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------");

        Scanner input = new Scanner(System.in);

        boolean validate;

        String answerName;
        String answerPassword;

        do {
            System.out.println("----------------------------------FIRST STEP----------------------------------------");
            System.out.print("Please enter your name: ");
            answerName = input.nextLine();
            String finalNameAnswer = answerName;

            validate = getUsers(finalNameAnswer).equals(finalNameAnswer);
            System.out.println("Wrong name, please enter your name again");
            System.out.println("Remember - it is case sensitive");

        } while (validate);

        System.out.println("CORRECT NAME!");
/*
        do {
            System.out.println("----------------------------------SECOND STEP---------------------------------------");
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

*/
    }


    public String getUsers(String name) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            String user = session.createQuery("FROM User WHERE user_name = " + name, User.class).uniqueResult().toString();


            session.getTransaction().commit();
            return user;
        }
    }


    public void loginFromDatabase() {

    }
}


