/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.c4r2.repository;

import com.sergioarboleda.c4r2.crud.UserCrudRepository;
import com.sergioarboleda.c4r2.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author camilo
 */
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    public List<User> getAll() {
        return userCrudRepository.findAll();
    }
    
    public Optional<User> getById(Integer id) {
        return userCrudRepository.findById(id);
    }
    
    public User save(User user) {
        return userCrudRepository.save(user);
    }
    
    public void delete(Integer id) {
        userCrudRepository.deleteById(id);
    }
    
    //CUSTOMS
    public List<User> findByEmail(String email){
        return userCrudRepository.findByEmail(email);
        
    }
    
    public Optional<Object> findByEmailAndPassword(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
        
    }
}
