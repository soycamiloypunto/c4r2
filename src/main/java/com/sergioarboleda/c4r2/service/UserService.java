/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.c4r2.service;

import com.sergioarboleda.c4r2.entity.User;
import com.sergioarboleda.c4r2.entity.custom.UserAndMail;
import com.sergioarboleda.c4r2.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author camilo
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll() {
        return userRepository.getAll();
    }
    
    public Optional<User> getUser(Integer id) {
        return userRepository.getById(id);
    }
    
    public User save(User user){
        if(user.getId()==null){
            return userRepository.save(user);
        }else{
            Optional<User> e=userRepository.getById(user.getId());
            if(e.isEmpty()){
                return userRepository.save(user);
            }else{
                return user;
            }
        }
    }
    
    public User update(User user){
        if(user.getId()==null){
            return userRepository.save(user);
        }else{
            Optional<User> e=userRepository.getById(user.getId());
            if(!e.isEmpty()){
                if(user.getIdentification()!=null){
                    e.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    e.get().setName(user.getName());
                }
                if(user.getBirthtDay()!=null){
                    e.get().setBirthtDay(user.getBirthtDay());
                }
                if(user.getMonthBirthtDay()!=null){
                    e.get().setMonthBirthtDay(user.getMonthBirthtDay());
                }
                if(user.getAddress()!=null){
                    e.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    e.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    e.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    e.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    e.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    e.get().setType(user.getType());
                }
                
                userRepository.save(e.get());
                return e.get();
            }else{
                return user;
            }
        }
    }
    
    public boolean deleteUser(int id){
        Boolean aBoolean=getUser(id).map(user -> {
            userRepository.delete(id);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    
    
    //CUSTOMS
    public Boolean getByEmail(String email){
        //Cuento la lista para saber si existe algún registro con ese email
        if(userRepository.findByEmail(email).size()!=0){
            return true;
        }else{
            return false; 
        }
    }
    
    public Object getEmailAndPassword(String email, String password){
        //return userRepository.findByEmailAndPassword(email, password);
        Optional<Object> ExisteUsuario = userRepository.findByEmailAndPassword(email, password);
        System.out.println("ExisteUsuario: "+ExisteUsuario);
        
        if(ExisteUsuario.isPresent()==true){
            return userRepository.findByEmailAndPassword(email, password);
        }else{
            UserAndMail O= new UserAndMail();
            O.setName(null);
            O.setAddress(null);
            O.setCellPhone(null);
            O.setEmail(null);
            O.setPassword(null);
            O.setZone(null);
            O.setType(null);
            
            
            System.out.println("Objeto NULO: "+O);
            return O;
        }
        
        
    }

    public List<User> getBymonthBirthtDay(String monthBirthtDay){
        return userRepository.findBymonthBirthtDay(monthBirthtDay);
    }
    
}
