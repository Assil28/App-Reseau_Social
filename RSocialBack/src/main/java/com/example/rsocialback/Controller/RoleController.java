package com.example.rsocialback.Controller;

import com.example.rsocialback.Model.Role;
import com.example.rsocialback.Model.User;
import com.example.rsocialback.Services.RoleService;
import com.example.rsocialback.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/AddRole")
    public Role RegistreNewRole(@RequestBody Role role){ return roleService.AddRole(role);}

}

