package com.example.relationships.service;

import com.example.relationships.model.Address;
import com.example.relationships.model.Registration;
import com.example.relationships.model.User;
import com.example.relationships.model.UserRole;
import com.example.relationships.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RelationshipService implements RelationshipMethods {
    private final UsersRepository usersRepository;
    private final AddressesRepository addressesRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final RegistrationRepository registrationRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public void addUser(User user) {
        usersRepository.save(user);
    }



    @Override
    public void addAdress(Address address) {

        addressesRepository.save(address);

    }

    @Override
    public void addAdressToUser(Address address,Long id) {
        User user=usersRepository.findById(id).get();
        user.setAddress(address);
        usersRepository.save(user);
    }

    @Override
    public void addRole(UserRole role) {
        userRoleRepository.save(role);
    }

    @Override
    public void addRoleToUser(UserRole role, Long id) {
        User user=usersRepository.findById(id).get();
        user.setRole((List<UserRole>)role);
        usersRepository.save(user);
    }

    @Override
    public List<User> getUserAndAdress() {
        return usersRepository.findAll();
    }

    @Override
    public void addUser(Registration register) {
        var course = courseRepository.findById(register.getCourse().getId());
        course.ifPresent(value -> register.setCourse(courseRepository.getById(value.getId())));
        register.setRegistered_at(LocalDateTime.now());
        registrationRepository.save(register);
    }

    @Override
    public List<Registration> getReg() {
        return registrationRepository.findAll();
    }
}
