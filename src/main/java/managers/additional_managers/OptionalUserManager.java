package managers.additional_managers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tables.Question;
import tables.User;

import java.util.List;
import java.util.Optional;


public class OptionalUserManager {

    private final SessionFactory sessionFactory;

    public OptionalUserManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Optional<User> getOneUserWithOptional() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.createQuery("FROM User WHERE id_number = 1", User.class).uniqueResult();
            session.getTransaction().commit();
            return Optional.ofNullable(user);
        }
    }

    public Optional<Integer> addUserWithOptional(String userName, String userLastName,
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


}
