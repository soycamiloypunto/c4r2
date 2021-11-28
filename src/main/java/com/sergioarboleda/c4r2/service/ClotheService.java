/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.c4r2.service;

import com.sergioarboleda.c4r2.entity.Clothe;
import com.sergioarboleda.c4r2.repository.ClotheRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilo
 */
@Service
public class ClotheService {
     @Autowired
    private ClotheRepository clotheRepository;
    
    public List<Clothe> getAll(){
        return clotheRepository.getAll();
    }
    
    public Optional<Clothe> getClothe(String id){
        return clotheRepository.getClothe(id);
    }
    
    public Clothe save(Clothe clothe){
        if(clothe.getReference()==null){
            return clotheRepository.save(clothe);
        }else{
            Optional<Clothe> e=clotheRepository.getClothe(clothe.getReference());
            if(e.isEmpty()){
                return clotheRepository.save(clothe);
            }else{
                return clothe;
            }
        }
    }
    
    public Clothe update(Clothe clothe){
        
        if(clothe.getReference()==null){
            return clotheRepository.save(clothe);
        }else{
            Optional<Clothe> e=clotheRepository.getClothe(clothe.getReference());
            System.out.println("E es igual a: "+clothe.getSize());
            if(!e.isEmpty()){
                if(clothe.getCategory()!=null){
                    e.get().setCategory(clothe.getCategory());
                }
                if(clothe.getSize()!=null){
                    e.get().setSize(clothe.getSize());
                }
                if(clothe.getDescription()!=null){
                    e.get().setDescription(clothe.getDescription());
                }
                if(clothe.getPhotography()!=null){
                    e.get().setPhotography(clothe.getPhotography());
                }
                clotheRepository.save(e.get());
                return e.get();
            }else{
                return clothe;
            }
        }
    }
    
    public boolean deleteClothe(String id){
        
        
        Boolean aBoolean=getClothe(id).map(user -> {
            clotheRepository.delete(id);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    
    
    //CUSTOMS
}
