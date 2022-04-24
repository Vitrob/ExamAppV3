package additionalFeatures;

import managers.UserManager;
import org.hibernate.SessionFactory;

import java.util.Scanner;

public class CustomUser {
    private static String userName;
    private static String userLastName;
    private static String password;
    private static int permissionLevel;
    private static int result;
/*
    // ROZWAŻMY MOŻLIWOść DODAWANIA STUDENTÓW SCANNEREM
    public static void addUserManually(SessionFactory sessionFactory) {
        boolean validate = false;
        Scanner input = new Scanner(System.in);
        String answer;

        do {
            System.out.print("Do you want to insert another user manually, please answer Y/N: ");


            answer = input.nextLine();

            if (!answer.equals("Y") && !answer.equals("N")) {
                System.out.print("Wrong answer, try again!");
                System.out.println();
                validate = true;
            } else {
                if (answer.equals("Y")) {
                    validate = false;

                    addCustomUser(sessionFactory);
                }

                if (answer.equals("N")) {
                    break;
                }

            }
        } while (validate);


    }

    public static void addCustomUser(SessionFactory sessionFactory) {

// trzeba jeszcze obsłużyć miejsca gdzie scanner daje int, żeby nie przekazał znaku
        // poza tym tutaj nie damy permission level i result - do przerobienia
        Scanner input = new Scanner(System.in);

        System.out.print("Insert your name:");
        userName = input.nextLine();
        System.out.print("Insert your last name:");
        userLastName = input.nextLine();
        System.out.print("Insert your password:");
        password = input.nextLine();
        System.out.print("Insert your permission level:");
        permissionLevel = input.nextInt();
        System.out.print("Insert your result:");
        result = input.nextInt();

        UserManager userManager = new UserManager(sessionFactory);
        userManager.addUser(userName,userLastName,password,permissionLevel,result);
    }


 */
}



