package com.example.relationships.controller;

import com.example.relationships.model.Address;
import com.example.relationships.model.Registration;
import com.example.relationships.model.User;
import com.example.relationships.model.UserRole;
import com.example.relationships.service.RelationshipService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/relationships")
@RequiredArgsConstructor
public class UsersController {
    private final RelationshipService service;

    @PostMapping("/users")
    public void addUsers(@RequestBody User user) {
        service.addUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getUserAndAdress();
    }

    @PostMapping("/address/{id}")
    public void addAddress(@RequestBody Address address,@PathVariable Long id) {
        service.addAdress(address);
        service.addAdressToUser(address,id);
    }
    @PostMapping("/role/{id}")
    public void addRole(@RequestBody UserRole role,@PathVariable Long id){
        service.addRole(role);
        service.addRoleToUser(role,id);
    }

    @PostMapping("/registration")
    public void addRegister(@RequestBody Registration register){
        service.addUser(register);
    }
    @GetMapping("/registration")
    public List<Registration> getRegister(){
        return service.getReg();
    }

}
