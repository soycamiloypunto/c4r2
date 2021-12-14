/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sergioarboleda.c4r2.repository.crud;

import com.sergioarboleda.c4r2.entity.Clothe;
import com.sergioarboleda.c4r2.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 *
 * @author camilo
 */
public interface ClotheCrudRepository extends MongoRepository<Clothe, String> {

    public List<Clothe> findByDescriptionContainingIgnoreCase(String description);

    public List<Clothe> findByPrice(Double price);

}
