package additionalFeatures.additional_managers;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tables.Question;
import java.util.Optional;

public class AdditionalQuestionManager {

    private final SessionFactory sessionFactory;

    public AdditionalQuestionManager(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Optional<Integer> addQuestionsWithOptional(String questionText, String correctAnswerText, String wrongAnswerText1,
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

}
