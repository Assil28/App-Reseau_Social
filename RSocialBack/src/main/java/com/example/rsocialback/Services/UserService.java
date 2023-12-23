package com.example.rsocialback.Services;

import com.example.rsocialback.Dao.*;
import com.example.rsocialback.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PublicationDao publicationDao;

    @Autowired
    private JaimeDao jaimeDao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private InvitationDoa invitationDoa;


    public User RegistreNewUser(User user)
    {
        Role role = roleDao.findById("client").get();
        Set<Role> Roles=new HashSet<>();
        Roles.add(role);
        user.setMotpasse(getEncodedPassword(user.getMotpasse()));
        user.setRole(Roles);
        userDao.save(user);
        return user;
    }


    public User ModifierUser(String id,User user)
    {
        User user1=this.userDao.findById(id).get();
        if (!user.getNom().equals("")) {
            user1.setNom(user.getNom());
        }
        if(!user.getPrenom()){
            user1.setPrenom(user.getPrenom());
        }
        if(!user.getEmail().equals("")){
            user1.setEmail(user.getEmail());
        }
        if(!user.getDateNaissance().equals("")){
            user1.setDateNaissance(user.getDateNaissance());
        }
        if(!user.getTel().equals("")){
            user1.setTel(user.getTel());
        }
        if(!user.getLocal().equals("")){
            user1.setLocal(user.getLocal());
        }

        return this.userDao.save(user1);
    }


    public void init(){
        Role role=new Role();
        role.setNom("client");
        role.setDescription("role for client");
        roleDao.save(role);
    }
    public User imageProfil(MultipartFile image,String username) throws IOException {
        User user =this.userDao.findById(username).get();
    user.setImageprofil(imageconfig(image));
    return this.userDao.save(user);}



    public ImageModel imageconfig(MultipartFile image) throws IOException {
        ImageModel imag=new ImageModel(image.getOriginalFilename(),image.getContentType(),image.getBytes());
        return imag;
    }

    public ImageModel getprofilImage(String username){
        User user =this.userDao.findById(username).get();
        ImageModel image=user.getImageprofil();
return image;
    }

    public Publication AddPublication(Publication publication,String username)
    {
    publication.setUser(this.userDao.findById(username).get());
        this.publicationDao.save(publication);
        return publication;
    }

    public Set<Publication> GetPublication(String username)
    {
        User user=this.userDao.findById(username).get();
        return  user.getPublication();
    }

public Jaime AimerPublication(Jaime jaime)
{
    Jaime jaime1=new Jaime();
    jaime1.setUser(jaime.getUser());
    jaime1.setPublication(jaime.getPublication());
    return jaimeDao.save(jaime1);
}

public Set<String> getJaimePublication(Long id){
     Publication publication = publicationDao.findById(id).get();
       List<Jaime> publications = publication.getJaime();
       Set<String> usernames=new HashSet<>();
       for(int i=0;i<publications.size();i++){
           usernames.add(publications.get(i).getUser().getUsername().toString());
       }
       return usernames;
}

    public String SendInvitation(String username1,String username2){
        User user1=this.userDao.findById(username1).get();
        User user2=this.userDao.findById(username2).get();
     Invitation invitation=new Invitation();
     invitation.setUser(user2);
     invitation.setFrom_user(user1);
     invitation.setResourceType(ResourceType.ENATTENTE);
     Set<Invitation> invitationssend=user1.getSend_inviatation();
     invitationssend.add(invitation);
     user1.setSend_inviatation(invitationssend);
     Set<Invitation> invitationsget=user2.getInvitation();
     invitationsget.add(invitation);
     user2.setInvitation(invitationsget);
     this.userDao.save(user1);
     this.userDao.save(user2);
     return "okay";
    }
    public String accepter(Long id){
        Invitation invitation=this.invitationDoa.findById(id).get();
        invitation.setResourceType(ResourceType.ACCEPTER);
        User user1=this.userDao.findById(invitation.getFrom_user().getUsername()).get();
        User user2=this.userDao.findById(invitation.getUser().getUsername()).get();

        Set<User> users=user1.getFrendes();
        users.add(user2);
        user1.setFrendes(users);
        this.userDao.save(user1);
        Set<User> freinds=user2.getFrendes();
        freinds.add(user1);
        user2.setFrendes(freinds);
        this.userDao.save(user2);
        return "okay";
    }




    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
