package tables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_number")
    private int idNumber;

    @Column(name = "question_text", nullable = false)
    private String questionText;
/*
    @Column(name = "correct_answer_text", nullable = false)
    private String correctAnswerText;

    @Column(name = "wrong_answer_text1", nullable = false)
    private String wrongAnswerText1;

    @Column(name = "wrong_answer_text2", nullable = false)
    private String wrongAnswerText2;

    @Column(name = "wrong_answer_text3", nullable = false)
    private String wrongAnswerText3;

 */
}
