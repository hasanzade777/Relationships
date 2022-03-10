package com.example.relationships.repository;

import com.example.relationships.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressesRepository extends JpaRepository<Address, Long> {
}