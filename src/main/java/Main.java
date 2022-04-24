

import fillTables.FillWithUsers;
import managers.QuestionManager;
import managers.UserManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tables.Question;
import tables.User;




public class Main {
    public static void main(String[] args) {


        try (SessionFactory factory = new Configuration()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory()) {


            UserManager userManager = new UserManager(factory);
            QuestionManager questionManager = new QuestionManager(factory);
            FillWithUsers fillWithUsers = new FillWithUsers(factory);
            userManager.deleteUsers();
            questionManager.deleteQuestions();

           fillWithUsers.addUsers();



            System.out.println(userManager.getUsers());


            System.out.println(userManager.getUsers());
            System.out.println("Only one user: " + userManager.getOneUser());
            System.out.println("Only one userV2: " + userManager.getOneUserWithOptional());




        } catch (Exception e) {
            System.out.printf("Error: %s%n", e.getMessage());
        }


    }
}


