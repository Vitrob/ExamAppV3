package fillTables;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tables.Question;
import java.util.List;


public class FillWithQuestions {

    private final SessionFactory sessionFactory;

    public FillWithQuestions(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public List<Question> addQuestions() {
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
        questions = List.of(question1, question2,question3,question4,question5,question6,question7,question8,question9,question10);
        Session session = sessionFactory.openSession();
        session.beginTransaction();


        questions.forEach(session::save);
        session.getTransaction().commit();
return questions;
    }
}
