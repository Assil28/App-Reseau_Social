package com.example.rsocialback.Controller;

import com.example.rsocialback.Model.JwtRequest;
import com.example.rsocialback.Model.JwtResponse;
import com.example.rsocialback.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;

@CrossOrigin("http://localhost:4200")
@RestController
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/Authenticate")
    public JwtResponse CreateJwtToken(@RequestBody JwtRequest jwtRequest)throws  Exception{

        return jwtService.createJwtToken(jwtRequest);
    }

}