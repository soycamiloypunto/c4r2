/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.c4r2.controller;

import com.sergioarboleda.c4r2.entity.Order;
import com.sergioarboleda.c4r2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author camilo
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable Integer id) {
        return orderService.getOrder(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Integer id) {
        return orderService.deleteOrder(id);
    }

    //CUSTOMS
    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona) {
        return orderService.findByZone(zona);
    }

    @GetMapping("/salesman/{id}")
    public List<Order> findBySalesMan(@PathVariable("id")int idSales){
        return orderService.findBySalesMan(idSales);
    }

    @GetMapping("/state/{status}/{id}")
    public List<Order> findByStatus(@PathVariable("status")String status, @PathVariable("id")int idSales){
        return orderService.findByStatus(status,idSales);
    }

    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> findByRegisterDay(@PathVariable("registerDay")String registerDay,@PathVariable("id")int idSales){
        return  orderService.findByRegisterDay(registerDay,idSales);
    }
}
