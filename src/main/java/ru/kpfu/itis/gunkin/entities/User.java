package ru.kpfu.itis.gunkin.entities;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JacksonInject;
import org.codehaus.jackson.map.annotate.JsonView;
import ru.kpfu.itis.gunkin.json.Views;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users", schema = "public", catalog = "music_school")
public class User {
    private int userId;
    private Integer phone;
    private String firstName;
    private String lastName;
    private String profileImage;
    private String info;
    @JsonIgnore
    private String login;
    @JsonIgnore
    private String password;
    @JsonIgnore
    private String userRole;
    @JsonIgnore
    private List<Comment> comments = new ArrayList<Comment>();
    private List<School> schools = new ArrayList<School>();

    public User(String login, String password, String firstName, String lastName, Integer phone, String info) {
        this.login = login;
        this.password = password;
        this.userRole = "ROLE_USER";
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.profileImage = "profile.jpg";
        this.info = info;
    }

    public User() {
    }

    @OneToMany(targetEntity = Comment.class, mappedBy = "user")
    @JsonBackReference
    public List<Comment> getComments() {
        return comments;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "users")
    @JsonBackReference
    public List<School> getSchools() {
        return schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String userLogin) {
        this.login = userLogin;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "user_role")
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String userName) {
        this.firstName = userName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String userSurname) {
        this.lastName = userSurname;
    }

    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "profile_image")
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Basic
    @Column(name = "info")
    public String getInfo() {
        return info;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setInfo(String userInfo) {
        this.info = userInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (userRole != null ? !userRole.equals(user.userRole) : user.userRole != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (phone != user.phone) return false;
        if (profileImage != null ? !profileImage.equals(user.profileImage) : user.profileImage != null) return false;
        if (info != null ? !info.equals(user.info) : user.info != null) return false;
        return  !(comments != null ? !comments.equals(user.comments) : user.comments != null);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public int income() {
        int income = 0;
        for (School school : schools)
            income += school.getCost();
        return income;
    }

    public int schoolCount() {
        return schools.size();
    }
}
