package com.example.relationships.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Contact> contact;
}
