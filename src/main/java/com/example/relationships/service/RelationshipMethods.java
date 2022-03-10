package com.example.relationships.service;

import com.example.relationships.model.Address;
import com.example.relationships.model.User;

import java.util.List;

public interface RelationshipMethods {
    void addUser(User user);
    void addAdress(Address address);
    List<User> getUserAndAdress();
}
