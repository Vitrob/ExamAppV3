package managers;


import generateQuestions.RandomQuestion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tables.Question;
import tables.User;

import java.util.List;
import java.util.Optional;

public class QuestionManager {

    private final SessionFactory sessionFactory;

    public QuestionManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Question> getQuestion() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Question> questions = session.createQuery("FROM tables.Question", Question.class).list();
            session.getTransaction().commit();
            return questions;
        }
    }


    public Optional<Integer> addQuestions(String questionText) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(
                    Question.builder()
                            .questionText(questionText)
                            .build());
            session.getTransaction().commit();
            return Optional.ofNullable(id);
        }
    }



    public void deleteQuestions() {
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.createQuery("DELETE FROM tables.Question").executeUpdate();
            session.getTransaction().commit();
        }
    }

}
