package com.Signup.authWithBcrypt.models;
import javax.persistence.*;
import java.util.List;

@Entity
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;
    @OneToMany(mappedBy = "username" , cascade = CascadeType.ALL)
    private List<PostUser> posts;

    public SiteUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public List<PostUser> getPosts() {
        return posts;
    }

    public SiteUser setPosts(List<PostUser> posts) {
        this.posts = posts;
        return this;
    }
    public SiteUser() {

    }
}