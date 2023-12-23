package com.example.rsocialback.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    public String Username;
    public String Nom;
    public String Prenom;

    public String DateNaissance;
    public String Local;
    public String Tel;
    public String Email;
    public String Motpasse;
    @OneToMany(mappedBy = "user",cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Jaime> jaime;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profil_image")
    public ImageModel imageprofil;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<ImageModel> imagemodel;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Invitation> invitation;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Invitation> send_inviatation;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "user")
    public Set<Publication> publication;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "User_Role", joinColumns =
            {
                    @JoinColumn(name = "User_Name")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Role_Name")
            }
    )
    public Set<Role> role;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Freiend", joinColumns =
            {
                    @JoinColumn(name = "User")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "User_Freind")
            }
    )
    public Set<User> Frendes;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Freiend", joinColumns =
            {
                    @JoinColumn(name = "User_Freind")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "User")
            }
    )
    public Set<User> FrendesOf;





    public User() {
    }

    public Set<User> getFrendes() {
        return Frendes;
    }

    public void setFrendes(Set<User> frendes) {
        Frendes = frendes;
    }

    public Set<User> getFrendesOf() {
        return FrendesOf;
    }

    public void setFrendesOf(Set<User> frendesOf) {
        FrendesOf = frendesOf;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }



    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        DateNaissance = dateNaissance;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String local) {
        Local = local;
    }


    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMotpasse() {
        return Motpasse;
    }

    public void setMotpasse(String motpasse) {
        Motpasse = motpasse;
    }

    public ImageModel getImageprofil() {
        return imageprofil;
    }

    public void setImageprofil(ImageModel imageprofil) {
        this.imageprofil = imageprofil;
    }

    public Set<ImageModel> getImagemodel() {
        return imagemodel;
    }

    public void setImagemodel(Set<ImageModel> imagemodel) {
        this.imagemodel = imagemodel;
    }

    public Set<Publication> getPublication() {
        return publication;
    }

    public void setPublication(Set<Publication> publication) {
        this.publication = publication;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Set<Jaime> getJaime() {
        return jaime;
    }

    public void setJaime(Set<Jaime> jaime) {
        this.jaime = jaime;
    }

    public Set<Invitation> getInvitation() {
        return invitation;
    }

    public void setInvitation(Set<Invitation> invitation) {
        this.invitation = invitation;
    }

    public Set<Invitation> getSend_inviatation() {
        return send_inviatation;
    }

    public void setSend_inviatation(Set<Invitation> send_inviatation) {
        this.send_inviatation = send_inviatation;
    }
}

