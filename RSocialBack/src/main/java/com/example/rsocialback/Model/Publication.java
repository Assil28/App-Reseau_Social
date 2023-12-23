package com.example.rsocialback.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_post")
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "publication", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Jaime> jaime;

    public Publication() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Jaime> getJaime() {
        return jaime;
    }

    public void setJaime(List<Jaime> jaime) {
        this.jaime = jaime;
    }
}
