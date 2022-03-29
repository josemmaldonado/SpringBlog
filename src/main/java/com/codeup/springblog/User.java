package com.codeup.springblog;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
//    @JoinColumn (name="post_id")
    private List<Post> post;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false, length = 100)

    private String username;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @OneToMany(mappedBy = "username")
    private List<Post> userPosts;

//    public User (User copy){
//        id=copy.id;
//        email = copy.email;
//        username = copy.username;
//        password = copy.password;
//    }

}
