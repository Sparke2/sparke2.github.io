package com.rebrova.pizzaproject.exeption;

public class PizzaNotFoundException extends RuntimeException{
    public PizzaNotFoundException(int id){
        super("Could not found the pizza with id "+id);
    }
}
