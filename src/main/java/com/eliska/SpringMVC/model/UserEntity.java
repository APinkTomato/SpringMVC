package com.eliska.SpringMVC.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "articles")
public class UserEntity {

    //@Column(name = "id_user")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
   // @NotBlank(message = "Uživatelské jméno je povinné pole")
    private String userName;

    @Getter
    @Setter
   // @Email
    //@NotBlank(message = "E-mail je povinné pole")
    private String email;

    //ctor
    public UserEntity() {};

    //ctor
    public UserEntity(String userName, String email) {
        this.userName = userName;
        this.email = email;
    };
}
