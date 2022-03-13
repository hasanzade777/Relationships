package com.example.relationships.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    LocalDateTime registered_at;
    @ManyToOne(cascade = CascadeType.ALL)
    Course course;
    @ManyToOne(cascade = CascadeType.ALL)
    Student student;
}
