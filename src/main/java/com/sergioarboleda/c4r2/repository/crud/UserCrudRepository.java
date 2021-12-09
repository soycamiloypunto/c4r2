/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sergioarboleda.c4r2.repository.crud;

import com.sergioarboleda.c4r2.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author camilo
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {
    public List<User> findByEmail(String email);
    public Optional<Object> findByEmailAndPassword (String email, String password);
}
