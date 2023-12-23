package com.example.rsocialback.Model;

import javax.persistence.*;

@Entity
public class Jaime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade =  CascadeType.MERGE)
    @JoinColumn(name = "user_jaime")
    private User user;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="post")
    private Publication publication;

    public Jaime() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
}
