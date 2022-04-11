
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


            userManager.deleteUsers();
            questionManager.deleteQuestions();


            questionManager.addQuestions("Jaka jest stolica Madagaskaru?");
            questionManager.addQuestions("Ile wynosi prędkość światła?");
            questionManager.addQuestions("Kierowca Fiata ma brata, ale brat kierowcy Fiata nie ma brata. Kim jest kierowca Fiata?");
            questionManager.addQuestions("Z naprzeciwka jadą dwa pociągi o prędkości 300km/h. Jaka jest ich łączna prędkość?");
            questionManager.addQuestions("pytanie?");
            questionManager.addQuestions("pytanie?");
            questionManager.addQuestions("pytanie?");
            questionManager.addQuestions("pytanie?");
            questionManager.addQuestions("pytanie?");
            questionManager.addQuestions("pytanie?");


            System.out.printf("Following user is added to the database: %s%n", userManager
                    .addUser("Jan", "Kowalski", "OKOŃ", 0, 5));

            System.out.printf("Following user is added to the database: %s%n", userManager
                    .addUser("Marian", "Nowak", "n3fry7", 1, 0));

            System.out.println(userManager.getUsers());
            //  CustomUser.addUserManually(factory);

            System.out.println(userManager.getUsers());


            System.out.println(questionManager);

        } catch (Exception e) {
            System.out.printf("Error: %s%n", e.getMessage());
        }


    }
}


