package com.eliska.SpringMVC.service;

import com.eliska.SpringMVC.model.ArticleEntity;
import com.eliska.SpringMVC.model.UserEntity;
import com.eliska.SpringMVC.repository.ArticleRepository;
import com.eliska.SpringMVC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    public ArticleEntity createArticle(Long userId, String title, String text) {

        UserEntity author = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        ArticleEntity article = new ArticleEntity(title, text);

        article.setAuthor(author);

        return articleRepository.save(article);
    }

    public List<ArticleEntity> getArticlesByUser(Long userId) {
        return articleRepository.findByAuthorId(userId);
    }

    public List<ArticleEntity> getAllArticles() {
        return articleRepository.findAll();
    }

}
