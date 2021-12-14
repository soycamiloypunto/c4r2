/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.c4r2.controller;

import com.sergioarboleda.c4r2.entity.User;
import com.sergioarboleda.c4r2.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author camilo
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
    
    //Customs
    @GetMapping("/emailexist/{email}")
    public Boolean getByEmail(@PathVariable("email") String email){
        return userService.getByEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public Object getEmailAndPassword(
            @PathVariable("email") String email, @PathVariable("password") String password){
        return userService.getEmailAndPassword(email, password);
    }
    @GetMapping("/birthday/{monthBirthtDay}")
    public List<User> getBymonthBirthtDay(@PathVariable("monthBirthtDay") String monthBirthtDay){
        return userService.getBymonthBirthtDay(monthBirthtDay);
    }

}
