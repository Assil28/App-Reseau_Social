package com.example.rsocialback.Model;

import javax.persistence.*;

@Entity
public class Invitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_invitation")
    private User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="fromUser")
    private User from_user;
    @Enumerated(EnumType.STRING)
    @Column(name="resourceType")
    private ResourceType resourceType;

    public Invitation() {
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

    public User getFrom_user() {
        return from_user;
    }

    public void setFrom_user(User from_user) {
        this.from_user = from_user;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }
}
