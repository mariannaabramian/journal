package com.marka.journal.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Users")
public class


User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "S_USERS", allocationSize = 1)
    private int id;

    @Column(length = 50, nullable = false, unique = true)
    @Size(min = 4, max = 50, message = "Login should be at least 4 characters length.")
    @Pattern(regexp = "[a-zA-Z-_.0-9]*",
            message = "Only letters, digits, underscore, minus sign and " +
                    " dots are allowed in login.")
    private String login;

    @Column(length = 250, nullable = false, name = "PSWD")
    private String encodedPassword;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column
    @Max(1000000)
    @PositiveOrZero
    private int bonusScore;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @Temporal(TemporalType.TIMESTAMP)
    @PastOrPresent
    private Date registrationDate;

    public String formFIO(){ return this.lastName+' '+this.firstName;}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEncodedPassword() {
        return encodedPassword;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public int getBonusScore() {
        return bonusScore;
    }

    public void setBonusScore(int bonusScore) {
        this.bonusScore = bonusScore;
    }
}
