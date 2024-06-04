package com.softuni.Pathfinder.model.entities;

import com.softuni.Pathfinder.model.enums.UserLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String userName;


    private Integer age;

    @Column(nullable = false)
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(unique = true)
    private String email;

    @ManyToMany
    private Set <Role> roles;

    @Enumerated(EnumType.STRING)
    private UserLevel level;

    public User(){
        this.roles = new HashSet<>();
    }
}
