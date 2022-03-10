package com.example.relationships.controller;

import com.example.relationships.model.Address;
import com.example.relationships.model.User;
import com.example.relationships.service.RelationshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/relationships")
@RequiredArgsConstructor
public class UsersController {
    private final RelationshipService service;

    @Transactional
    @PostMapping("/users")
    public void addUsers(@RequestBody User user) {
        service.addUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getUserAndAdress();
    }

    @PostMapping("/address")
    public void addAddress(@RequestBody Address address) {
        service.addAdress(address);
    }
}
