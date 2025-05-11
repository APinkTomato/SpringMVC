package com.eliska.SpringMVC.repository;

import com.eliska.SpringMVC.model.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    List<ArticleEntity> findByAuthorId(Long authorId);
}
