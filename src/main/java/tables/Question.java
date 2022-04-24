package tables;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_number")
    private int idNumber;

    @NonNull
    @Column(name = "question_text", nullable = false)
    private String questionText;

    @NonNull
    @Column(name = "correct_answer_text", nullable = false)
    private String correctAnswerText;

    @NonNull
    @Column(name = "wrong_answer_text1", nullable = false)
    private String wrongAnswerText1;

    @NonNull
    @Column(name = "wrong_answer_text2", nullable = false)
    private String wrongAnswerText2;

    @NonNull
    @Column(name = "wrong_answer_text3", nullable = false)
    private String wrongAnswerText3;


}
