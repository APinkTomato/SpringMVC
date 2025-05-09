package com.eliska.SpringMVC.repository;

import com.eliska.SpringMVC.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByOrderByIdDesc();

    Optional<UserEntity> findByUserName(String username);

    // Automaticky generovaná metoda
    List<UserEntity> findByEmailContaining(String text);

    // custom JPQL dotaz
    @Query("SELECT p FROM UserEntity p WHERE p.userName LIKE %:keyword%")
    List<UserEntity> searchByUserName(@Param("keyword") String keyword);


}

