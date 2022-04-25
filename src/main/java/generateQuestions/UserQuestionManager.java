package generateQuestions;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tables.Question;

import java.util.ArrayList;
import java.util.List;


public class UserQuestionManager {

    private final SessionFactory sessionFactory;
    RandomQuestion randomQuestion = new RandomQuestion();

    public UserQuestionManager(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }


    public List<Question> getQuestions() {

        List<Question> questions = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            for (int number : randomQuestion.get5RandomNumbers()
            ) {
                questions.add(session.createQuery("FROM Question WHERE id_number =" + number, Question.class).uniqueResult());
            }

            session.getTransaction().commit();

        }
        return questions;
    }

}