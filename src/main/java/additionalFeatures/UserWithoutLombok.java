package additionalFeatures;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserWithoutLombok {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_number")
    private int idNumber;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "password")
    private String password;

    @Column(name = "permission_level")
    private int permissionLevel;

    @Column(name = "result")
    private int result;

  //  @ManyToMany
  //  private tables.Question question;

    public UserWithoutLombok() {
    }


    public UserWithoutLombok(String userName, String userLastName,
                             String password, int permissionLevel, int result) {

        this.userName = userName;
        this.userLastName = userLastName;
        this.password = password;
        this.permissionLevel = permissionLevel;
        this.result = result;

    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }


    @Override
    public String toString() {
        return "tables.User{" +
                "idNumber=" + idNumber +
                ", userName='" + userName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", password='" + password + '\'' +
                ", permissionLevel=" + permissionLevel +
                ", result=" + result +
                '}';
    }
}