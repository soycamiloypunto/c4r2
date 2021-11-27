/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sergioarboleda.c4r2.crud;

import com.sergioarboleda.c4r2.entity.Clothe;
import com.sergioarboleda.c4r2.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author camilo
 */
public interface ClotheCrudRepository extends MongoRepository<Clothe, String> {
    
}
