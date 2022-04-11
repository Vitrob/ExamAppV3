package managers;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tables.UserV3;

import java.util.List;
import java.util.Optional;

public class UserManagerV3 {

    private final SessionFactory sessionFactory;

    public UserManagerV3(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<UserV3> getUsers() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<UserV3> users = session.createQuery("FROM tables.User", UserV3.class).list();
            session.getTransaction().commit();
            return users;
        }
    }


    public Optional<Integer> addUser(String userName, String userLastName,
                                     String password, int permissionLevel, int result) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(
                    new UserV3(userName, userLastName, password, permissionLevel,result));
            session.getTransaction().commit();
            return Optional.ofNullable(id);
        }
    }


    public void deleteUsers() {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.createQuery("DELETE FROM tables.User").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
