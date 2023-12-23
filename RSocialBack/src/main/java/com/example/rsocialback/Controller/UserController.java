package com.example.rsocialback.Controller;

import com.example.rsocialback.Model.ImageModel;
import com.example.rsocialback.Model.Jaime;
import com.example.rsocialback.Model.Publication;
import com.example.rsocialback.Model.User;
import com.example.rsocialback.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@CrossOrigin("http://localhost:4200")

@RestController
public class UserController {
    @Autowired

    private UserService userService;
    @PostConstruct
    public void init(){
        userService.init();
    }
    @PostMapping("/RegistreUser")
    public User RegistreNewUser(@RequestBody User user){
        return userService.RegistreNewUser(user);
    }
    @PostMapping(value="/image",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public User image(@RequestPart("imageFile") MultipartFile image,@RequestPart("username") String username) throws IOException {
        return this.userService.imageProfil(image,username);
    }

    @GetMapping("/getimageprofil/{username}")
    public ImageModel image(@PathVariable String username)  {
        return this.userService.getprofilImage(username);
    }

    @PostMapping("/ModifierUser/{id}")
    public User ModifierUser(@PathVariable String id,@RequestBody User user){
     return  this.userService.ModifierUser(id,user);
    }

    @PostMapping("/AddPublication/{username}")
    public Publication AddPublication(@RequestBody Publication publication,@PathVariable String username){
      return this.userService.AddPublication(publication,username);
    }

    @GetMapping("/GetPublication/{username}")
    public Set<Publication>GetPublication(@PathVariable String username){
        return this.userService.GetPublication(username);
    }


    @PostMapping("/AimerPublication")
    public Jaime AimerPublication(@RequestBody Jaime jaime)
    {
        return  this.userService.AimerPublication(jaime);
    }
    @GetMapping("/getjaimepub/{id}")
    public Set<String> getJaimePublication(@PathVariable Long id){
        return this.userService.getJaimePublication(id);
    }
    @PostMapping("/addfreind/{username1}/{username2}")
    public String SendInvitation(@PathVariable String username1,@PathVariable String username2){
        return  this.userService.SendInvitation(username1,username2);
    }
}
