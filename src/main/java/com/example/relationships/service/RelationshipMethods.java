package com.example.relationships.service;

import com.example.relationships.model.*;

import javax.management.relation.Role;
import java.util.List;

public interface RelationshipMethods {
    void addUser(User user);
    void addUser(Registration register);
    List<Registration> getReg();
    void addAdress(Address address);
    void addAdressToUser(Address address,Long id);
    void addRole(UserRole role);
    void addRoleToUser(UserRole role,Long id);
    List<User> getUserAndAdress();
}
