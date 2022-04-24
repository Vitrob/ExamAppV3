package managers;


import generateQuestions.RandomQuestion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tables.Question;
import tables.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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


    public Optional<Integer> addQuestions(String questionText, String correctAnswerText, String wrongAnswerText1,
                                          String wrongAnswerText2, String wrongAnswerText3) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(
                    Question.builder()
                            .questionText(questionText)
                            .correctAnswerText(correctAnswerText)
                            .wrongAnswerText1(wrongAnswerText1)
                            .wrongAnswerText2(wrongAnswerText2)
                            .wrongAnswerText3(wrongAnswerText3)
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
