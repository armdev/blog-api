package app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Post {

    private Long id;
    private User user;
    private String title;
    private String body;

    /**
     * Constructors
     */
    public Post() {}

    /**
     * Getters & Setters
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    public User getUser(){ return this.user; }
    public void setUser(User user) { this.user = user; }

    @Column(nullable = false)
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false)
    public String getBody() {
        return this.body;
    }
    public void setBody(String body) {
        this.body = body;
    }
}
