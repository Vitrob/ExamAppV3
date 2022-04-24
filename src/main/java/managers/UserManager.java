package managers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tables.Question;
import tables.User;

import java.util.List;
import java.util.Optional;


public class UserManager {

    private final SessionFactory sessionFactory;

    public UserManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
            User user = session.createQuery("FROM User WHERE id_number = 1", User.class).uniqueResult();

            session.getTransaction().commit();
            return user;
        }
    }

    public Optional<User> getOneUserWithOptional () {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.createQuery("FROM User WHERE id_number = 1", User.class).uniqueResult();
            session.getTransaction().commit();
            return Optional.ofNullable(user);
        }
    }

    public Optional<Integer> addUser(String userName, String userLastName,
                                     String password, int permissionLevel, int result, List<Question> questions) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(
                    User.builder()
                            .userName(userName)
                            .userLastName(userLastName)
                            .password(password)
                            .permissionLevel(permissionLevel)
                            .result(result)
                            .questions(questions)
                            .build());
            session.getTransaction().commit();
            return Optional.ofNullable(id);
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
