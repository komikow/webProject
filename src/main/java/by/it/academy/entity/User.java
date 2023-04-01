package by.it.academy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@NamedQuery(name = "getUserByLogin", query = "from User where login = :userLogin")
@Entity
@Table(name = "\"USER\"")
@Data
@AllArgsConstructor
public class User {
    @Id
    @SequenceGenerator(name = "seq-gen", sequenceName = "MY_SEQ_GEN", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq-gen")
    @Column(name = "\"USER_ID\"", unique = true, nullable = false)
    private int user_id;

    @Column(name = "\"FIRST_NAME\"")
    private String firstName;

    @Column(name = "\"SECOND_NAME\"")
    private String secondName;

    @Column(name = "\"AGE\"")
    private int age;

    @Column(name = "\"LOGIN\"")
    private String login;

    @Column(name = "\"PASSWORD\"")
    private String password;

    public User(String firstName, String secondName, int age, String login, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
