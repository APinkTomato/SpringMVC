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


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter

    private String userName;

    @Getter
    @Setter
   // @Email

    private String email;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ArticleEntity> articles = new ArrayList<>();

    //ctor
    public UserEntity() {};

    //ctor
    public UserEntity(String userName, String email) {
        this.userName = userName;
        this.email = email;
    };
}
