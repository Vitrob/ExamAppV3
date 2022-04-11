package tables;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@AllArgsConstructor
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

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_last_name", nullable = false)
    private String userLastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "permission_level", nullable = false)
    private int permissionLevel;

    @Column(name = "result", nullable = false)
    private int result;

    @ManyToMany (fetch = FetchType.EAGER)
    private List<Question> question;


}