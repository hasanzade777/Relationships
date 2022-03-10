package com.example.relationships.service;

import com.example.relationships.model.Address;
import com.example.relationships.model.User;
import com.example.relationships.repository.AddressesRepository;
import com.example.relationships.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelationshipService implements RelationshipMethods {
    private final UsersRepository usersRepository;
    private final AddressesRepository addressesRepository;
    @Override
    public void addUser(User user) {
        var address=addressesRepository.findById(user.getAddress().getId());
        address.ifPresent(user::setAddress);
        usersRepository.save(user);
    }

    @Override
    public void addAdress(Address address) {
        addressesRepository.save(address);
    }

    @Override
    public List<User> getUserAndAdress() {
        return usersRepository.findAll();
    }
}
