package managers;


import generateQuestions.UserQuestionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import tables.User;

import java.util.List;


public class UserManager {

    private final SessionFactory sessionFactory;

    public UserManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addUsers() {


        UserQuestionManager userQuestionManager = new UserQuestionManager(sessionFactory);


        User user1 = new User("Jan", "Kowalski", "OKOŃ", 0, 5, userQuestionManager.getQuestions());
        User user2 = new User("Marian", "Nowak", "n3frY7", 1, 3, userQuestionManager.getQuestions());
        User user3 = new User("Albert", "Einstein", "pass", 0, 4, userQuestionManager.getQuestions());
        User user4 = new User("Nikola", "Tesla", "qwerty", 1, 2, userQuestionManager.getQuestions());
        User user5 = new User("Sygryda", "Storråda", "świętosława", 1, 1, userQuestionManager.getQuestions());


        List<User> users = List.of(user1, user2, user3, user4, user5);


        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            users.forEach(session::save);
            session.getTransaction().commit();

        }

    }

    public List<User> getUsers() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<User> users = session.createQuery("FROM User", User.class).list();
            session.getTransaction().commit();
            return users;
        }
    }

    public User getOneUser() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
//            User user = session.createQuery("FROM User WHERE id_number = 1", User.class).uniqueResult();
            Query<User> query = session.createQuery("FROM User", User.class);
            query.setMaxResults(1);
            User user = query.uniqueResult();

            session.getTransaction().commit();
            return user;
        }
    }
    public User getOneUser(int userNumber) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.createQuery("FROM User WHERE id_number = " + userNumber, User.class).uniqueResult();


            session.getTransaction().commit();
            return user;
        }
    }

    public void deleteUsers() {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.createQuery("DELETE FROM User").executeUpdate();
            session.getTransaction().commit();
        }
    }

}