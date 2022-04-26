package tables;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_number")
    private int idNumber;

    @NonNull
    @Column(name = "user_name", nullable = false)
    private String userName;

    @NonNull
    @Column(name = "user_last_name", nullable = false)
    private String userLastName;

    @NonNull
    @Column(name = "password", nullable = false)
    private String password;

    @NonNull
    @Column(name = "permission_level", nullable = false)
    private int permissionLevel;

    @NonNull
    @Column(name = "result", nullable = false)
    private int result;

    @NonNull
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Question> questions;


}