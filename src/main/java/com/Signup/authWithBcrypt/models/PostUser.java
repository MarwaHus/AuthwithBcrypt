package com.Signup.authWithBcrypt.models;


import javax.persistence.*;

@Entity
public class PostUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String textContent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private SiteUser username;

    public PostUser(String textContent, SiteUser username) {
        this.textContent = textContent;
        this.username = username;
    }



    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public SiteUser getUsername() {
        return username;
    }

    public void setUsername(SiteUser username) {
        this.username = username;
    }
    public PostUser(){

    }
}
