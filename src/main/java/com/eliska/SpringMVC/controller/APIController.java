package com.eliska.SpringMVC.controller;

import com.eliska.SpringMVC.model.UserEntity;
import com.eliska.SpringMVC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/getall")
    public List<UserEntity> getAllUsers() {
        return userService.findAllByOrderByIdDesc();
    }

    /*
       GET - http://localhost:9090/api/users/findbyusername?username=eliska
        */
    @GetMapping("/users/findbyusername")
    public Optional<UserEntity> findByUsername(@RequestParam String username) {
        return userService.findByUserName(username);
    }

    /*
    GET - http://localhost:9090/api/users/searchbyusername?username=pe
     */
    @GetMapping("/users/searchbyusername")
    public List<UserEntity> searchByUsername(@RequestParam String username) {
        return userService.searchByUserName(username);
    }

    /*
    GET - http://localhost:9090/api/users/searchbyemail?email=.com
    */
    @GetMapping("/users/searchbyemail")
    public List<UserEntity> searchByEmail(@RequestParam String email) {
        return userService.searchByEmail(email);
    }

    /*
  GET - http://localhost:9090/api/createuser/testname/testemail@testdomain.com
   */
    @RequestMapping(value = {"/users/createuser/{username}/{email}"})
    public UserEntity createUserFromPath(@PathVariable(required = true) String username, @PathVariable(required = true) String email) {
        return userService.createUser(username, email);
    }

    /*
    GET - pomocí
     */
    @GetMapping("/users/createuser")
    public UserEntity createUserFromParamsGET(@RequestParam String username, @RequestParam String email) {
        return userService.createUser(username, email);
    }
}
