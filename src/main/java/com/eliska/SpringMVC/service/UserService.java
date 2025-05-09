package com.eliska.SpringMVC.service;

import com.eliska.SpringMVC.model.UserEntity;
import com.eliska.SpringMVC.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public List<UserEntity> findAllByOrderByIdDesc() {
        return userRepository.findAllByOrderByIdDesc();
    }

    public Optional<UserEntity> findByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    public List<UserEntity> searchByUserName(String username) {
        return userRepository.searchByUserName(username);
    }

    public List<UserEntity> searchByEmail(String email) {
        return userRepository.findByEmailContaining(email);
    }
}
