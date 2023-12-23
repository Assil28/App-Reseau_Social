package com.example.rsocialback.Model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nom;
    public String type;
    @Lob
    public byte picbyte[];
    public ImageModel() {
    }
@ManyToOne(cascade = CascadeType.MERGE)
@JoinColumn(name="user_image")
private User user;
    public ImageModel(String nom, String type, byte[] picbyte) {
        this.nom = nom;
        this.type = type;
        this.picbyte = picbyte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicbyte() {
        return picbyte;
    }

    public void setPicbyte(byte[] picbyte) {
        this.picbyte = picbyte;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
