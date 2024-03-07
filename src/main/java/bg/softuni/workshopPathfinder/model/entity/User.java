package bg.softuni.workshopPathfinder.model.entity;

import bg.softuni.workshopPathfinder.model.enums.LevelEnum;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(nullable = false,unique = true,name = "username")
    private String userName;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false,name = "full_name")
    private String fullName;
    @Column(nullable = false)
    private int age;
    @Column(unique = true)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "roles_id",referencedColumnName = "id")}
//    )
    private Set<Role> roles;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private LevelEnum level;

    public User(String userName, String password, String fullName, int age, String email) {
       this();
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
    }

    public User (){
    this.roles = new HashSet<>();
}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> role) {
        this.roles = role;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }
}
