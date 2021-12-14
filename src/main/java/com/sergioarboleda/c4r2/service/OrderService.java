/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.c4r2.service;

import com.sergioarboleda.c4r2.entity.Order;
import com.sergioarboleda.c4r2.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author camilo
 */
@Service
public class OrderService {
     @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAll(){
        return orderRepository.getAll();
    }
    
    public Optional<Order> getOrder(Integer id){
        return orderRepository.getOrder(id);
    }
    
    public Order save(Order order){
        if(order.getId()==null){
            return orderRepository.save(order);
        }else{
            Optional<Order> e=orderRepository.getOrder(order.getId());
            if(e.isEmpty()){
                return orderRepository.save(order);
            }else{
                return order;
            }
        }
    }
    
    public Order update(Order order){
        
        if(order.getId()==null){
            return orderRepository.save(order);
        }else{
            Optional<Order> e=orderRepository.getOrder(order.getId());
            if(!e.isEmpty()){
                if(order.getProducts()!=null){
                    e.get().setProducts(order.getProducts());
                }
                if(order.getQuantities()!=null){
                    e.get().setQuantities(order.getQuantities());
                }
                if(order.getRegisterDay()!=null){
                    e.get().setRegisterDay(order.getRegisterDay());
                }
                if(order.getStatus()!=null){
                    e.get().setStatus(order.getStatus());
                }
                if(order.getSalesMan()!=null){
                    e.get().setSalesMan(order.getSalesMan());
                }
                orderRepository.save(e.get());
                return e.get();
            }else{
                return order;
            }
        }
    }
    
    public boolean deleteOrder(Integer id){
        
        
        Boolean aBoolean=getOrder(id).map(user -> {
            orderRepository.delete(id);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }

    //CUSTOMS

    //Ordenes de pedido asociadas a los asesores de una zona
    public List<Order> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }

    public List<Order> findByStatus(String status, int idSales){
        return orderRepository.findByStatus(status,idSales);
    }

    public List<Order> findBySalesMan(int idSales){
        return orderRepository.findBySalesMan(idSales);
    }

    public List<Order> findByRegisterDay(String date, int idSales){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFormat = new Date();
        try{
            dateFormat= formato.parse(date);
            System.out.println("Fecha Parseada: "+dateFormat+" Fecha sin Parsear: "+date);

        }catch(ParseException e){
            e.printStackTrace();
        }
        System.out.println("Fecha Parseada que va a crud: "+dateFormat+" idSales: "+idSales);
        return orderRepository.findByRegisterDate(dateFormat, idSales);
    }
}
