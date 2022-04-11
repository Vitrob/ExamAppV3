package managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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


    public Optional<Integer> addUser(String userName, String userLastName,
                                     String password, int permissionLevel, int result) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(
                    User.builder()
                            .userName(userName)
                            .userLastName(userLastName)
                            .password(password)
                            .permissionLevel(permissionLevel)
                            .result(result)
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
