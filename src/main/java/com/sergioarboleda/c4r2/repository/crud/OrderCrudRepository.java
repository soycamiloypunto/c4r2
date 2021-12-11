/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sergioarboleda.c4r2.repository.crud;


import com.sergioarboleda.c4r2.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

/**
 *
 * @author camilo
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {

//    @Query("{'salesMan.zone':?0}")
//    public List<Order> findByZone(String country);
//
//    public List<Order> findByStatus(String status);
//
//    public List<Order> findByQuantities(String quantities);
//
//    public List<Order> findByQuantitiesAndSalesMan(String quantities);

    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);

    @Query("{status: ?0, 'salesMan.id': ?1}")
    List<Order> findByStatus(final String status, Integer id);

    @Query("{'salesMan.id': ?0}")
    List<Order> findBySalesMan(final Integer id);

    @Query("{registerDay: ?0, 'salesMan.id': ?1}")
    List<Order> findByRegisterDay(final Date registerDay, Integer id);
}
