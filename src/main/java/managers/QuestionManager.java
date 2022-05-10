package managers;


import managers.additional_managers.OptionalQuestionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tables.Question;


import java.util.List;


public class QuestionManager {

    private final SessionFactory sessionFactory;

    public QuestionManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addQuestions() {
        OptionalQuestionManager optionalQuestionManager = new OptionalQuestionManager(sessionFactory);
        optionalQuestionManager.addQuestionsWithOptional("question1?", "correct answer q1", "wrong answer q1", "wrong answer q1", "wrong answer q1");
        optionalQuestionManager.addQuestionsWithOptional("question2?", "correct answer q2", "wrong answer q2", "wrong answer q2", "wrong answer q2");
        optionalQuestionManager.addQuestionsWithOptional("question3?", "correct answer q3", "wrong answer q3", "wrong answer q3", "wrong answer q3");
        optionalQuestionManager.addQuestionsWithOptional("question4?", "correct answer q4", "wrong answer q4", "wrong answer q4", "wrong answer q4");
        optionalQuestionManager.addQuestionsWithOptional("question5?", "correct answer q5", "wrong answer q5", "wrong answer q5", "wrong answer q5");
        optionalQuestionManager.addQuestionsWithOptional("question6?", "correct answer q6", "wrong answer q6", "wrong answer q6", "wrong answer q6");
        optionalQuestionManager.addQuestionsWithOptional("question7?", "correct answer q7", "wrong answer q7", "wrong answer q7", "wrong answer q7");
        optionalQuestionManager.addQuestionsWithOptional("question8?", "correct answer q8", "wrong answer q8", "wrong answer q8", "wrong answer q8");
        optionalQuestionManager.addQuestionsWithOptional("question9?", "correct answer q9", "wrong answer q9", "wrong answer q9", "wrong answer q9");
        optionalQuestionManager.addQuestionsWithOptional("question10?", "correct answer q10", "wrong answer q10", "wrong answer q10", "wrong answer q10");

    }

    public List<Question> addQuestionsV2() {

        Question question1 = new Question("question1?", "correct answer", "wrong answer", "wrong answer", "wrong answer");
        Question question2 = new Question("question2?", "correct answer", "wrong answer", "wrong answer", "wrong answer");
        Question question3 = new Question("question3?", "correct answer", "wrong answer", "wrong answer", "wrong answer");
        Question question4 = new Question("question4?", "correct answer", "wrong answer", "wrong answer", "wrong answer");
        Question question5 = new Question("question5?", "correct answer", "wrong answer", "wrong answer", "wrong answer");
        Question question6 = new Question("question6?", "correct answer", "wrong answer", "wrong answer", "wrong answer");
        Question question7 = new Question("question7?", "correct answer", "wrong answer", "wrong answer", "wrong answer");
        Question question8 = new Question("question8?", "correct answer", "wrong answer", "wrong answer", "wrong answer");
        Question question9 = new Question("question9?", "correct answer", "wrong answer", "wrong answer", "wrong answer");
        Question question10 = new Question("question10?", "correct answer", "wrong answer", "wrong answer", "wrong answer");

        List<Question> questions;
        questions = List.of(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10);
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();


            questions.forEach(session::save);
            session.getTransaction().commit();
        }
        return questions;
    }

    public List<Question> getQuestions() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            List<Question> questions = session.createQuery("FROM Question", Question.class).list();
            session.getTransaction().commit();
            return questions;
        }
    }

    public Question getOneQuestion() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Question question = session.createQuery("FROM Question WHERE id_number = 1", Question.class).uniqueResult();

            session.getTransaction().commit();
            return question;
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
