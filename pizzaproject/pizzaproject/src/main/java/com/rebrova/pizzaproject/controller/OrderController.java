package com.rebrova.pizzaproject.controller;

import com.rebrova.pizzaproject.exeption.OrderNotFoundException;
import com.rebrova.pizzaproject.model.Order;
import com.rebrova.pizzaproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/add")
    String add(@RequestBody Order order) {
        orderRepository.save(order);
        return "Add order";
    }

    @GetMapping("/getAll")
    List<Order> getAllPizza() {
        return orderRepository.findAll();
    }

    @GetMapping("{id}")
    Order findById(@PathVariable int id) {
        return orderRepository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException(id));
    }
    @PutMapping("{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    Order updateOrder(@RequestBody Order newOrder, @PathVariable int id) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setStatus(newOrder.getStatus());
                    order.setPhone(newOrder.getPhone());
                    order.setAddress(newOrder.getAddress());
                    return orderRepository.save(order);
                }).orElseThrow(()->new OrderNotFoundException(id));
    }
}
