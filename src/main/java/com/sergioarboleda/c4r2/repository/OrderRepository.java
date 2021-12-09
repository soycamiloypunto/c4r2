package com.sergioarboleda.c4r2.repository;

import com.sergioarboleda.c4r2.repository.crud.OrderCrudRepository;
import com.sergioarboleda.c4r2.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author camilo
 */
@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    
    public List<Order> getAll() {
        return orderCrudRepository.findAll();
    }
    
    public Optional<Order> getOrder(Integer id) {
        return orderCrudRepository.findById(id);
    }
    
    public Order save(Order order) {
        return orderCrudRepository.save(order);
    }
    
    public void delete(Integer id) {
        orderCrudRepository.deleteById(id);
    }

    public List<Order> getOrderByZone(String zona){
        return orderCrudRepository.findByZone(zona);
    }

    public List<Order> getOrderByStatus(String status){
        return orderCrudRepository.findByStatus(status);
    }

    public List<Order> getOrderByQuantities(String quantities){
        return orderCrudRepository.findByStatus(quantities);
    }


}
