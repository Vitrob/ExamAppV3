package additionalFeatures;

import generateQuestions.RandomQuestion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tables.Question;
import tables.User;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UserQuestionManager {
    public UserQuestionManager(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    RandomQuestion randomQuestion = new RandomQuestion();

    List<Integer> idNumbers = new ArrayList<>();
    private final SessionFactory sessionFactory;


    public Optional<User> mapQuestionsToUsers() {
        idNumbers = randomQuestion.get5RandomNumbersV2();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();


            User user = session.createQuery("FROM User WHERE id_number = " + 1, User.class).uniqueResult();
            Question question = session.createQuery("FROM Question WHERE id_number = " + 1, Question.class).uniqueResult();


            session.getTransaction().commit();
            return Optional.ofNullable(user);


        }
    }


}