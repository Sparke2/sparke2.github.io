package com.rebrova.pizzaproject.service;

import com.rebrova.pizzaproject.model.Pizza;

import java.util.List;
import java.util.Optional;

public interface PizzaService {
    public Pizza savePizza(Pizza pizza);
    public List<Pizza> getAllPizza();

    public Optional<Pizza> findById(int id);

    Optional<Pizza> deleteById(int id);
}
