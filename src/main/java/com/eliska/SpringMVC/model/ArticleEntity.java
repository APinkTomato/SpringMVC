package com.eliska.SpringMVC.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;


    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    //ctor prazdny
    public ArticleEntity() {}
    //ctor
    public ArticleEntity(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
