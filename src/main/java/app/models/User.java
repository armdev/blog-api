package app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Access(AccessType.PROPERTY)
public class User {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    // Defaulted to False
    private Boolean admin = false;

    private List<Post> posts;

    /**
     * Constructors
     */
    public User() {}

    public User(Long id) {
        this.id = id;
    }

    /**
     * Getter & Setters
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true, nullable = false)
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false)
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getAdmin() {
        return this.admin;
    }
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    public List<Post> getPosts() { return this.posts; }
    public void setPosts(List<Post> posts) { this.posts = posts; }
}
