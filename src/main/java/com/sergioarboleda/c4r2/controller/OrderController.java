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
    @GetMapping("/zona/{zone}")
    public List<Order> getOrdersByZone(@PathVariable("zone") String zone){
        return orderService.getOrdersByZone(zone);
    }

    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable("status") String status){
        return orderService.getOrdersByStatus(status);
    }

    @GetMapping("/quantity/{quantity}")
    public List<Order> getOrdersByQuantity(@PathVariable("quantity") String quantity){
        return orderService.getOrdersByQuantities(quantity);
    }
}
