package com.rebrova.pizzaproject.exeption;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(int id){
        super("Could not found the order with id "+id);
    }
}
