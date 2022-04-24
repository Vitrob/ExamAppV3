package additionalFeatures;

import lombok.*;
import tables.Question;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class UserV3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_number")
    private int idNumber;

    @Column(name = "user_name", nullable = false)
    @NonNull
    private String userName;

    @Column(name = "user_last_name", nullable = false)
    @NonNull
    private String userLastName;

    @Column(name = "password", nullable = false)
    @NonNull
    private String password;

    @Column(name = "permission_level", nullable = false)
    @NonNull
    private int permissionLevel;

    @Column(name = "result", nullable = false)
    @NonNull
    private int result;

    @ManyToMany (fetch = FetchType.EAGER)
    private List<Question> question;


}