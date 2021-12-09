package com.sergioarboleda.c4r2.repository;

import com.sergioarboleda.c4r2.repository.crud.ClotheCrudRepository;
import com.sergioarboleda.c4r2.entity.Clothe;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author camilo
 */
@Repository
public class ClotheRepository {
    @Autowired
    private ClotheCrudRepository clotheCrudRepository;
    
    public List<Clothe> getAll() {
        return clotheCrudRepository.findAll();
    }
    
    public Optional<Clothe> getClothe(String id) {
        return clotheCrudRepository.findById(id);
    }
    
    public Clothe save(Clothe clothe) {
        return clotheCrudRepository.save(clothe);
    }
    
    public void delete(String id) {
        clotheCrudRepository.deleteById(id);
    }
}
