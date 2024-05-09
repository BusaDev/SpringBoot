package com.example.demoEs7.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data

public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false, unique = true)
    private String email;
}
