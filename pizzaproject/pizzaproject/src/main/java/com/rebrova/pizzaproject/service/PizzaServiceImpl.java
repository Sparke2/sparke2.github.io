package com.rebrova.pizzaproject.service;

import com.rebrova.pizzaproject.model.Pizza;
import com.rebrova.pizzaproject.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public Pizza savePizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }

    @Override
    public Optional<Pizza> findById(int id) {
        return pizzaRepository.findById(id);
    }

    @Override
    public Optional<Pizza> deleteById(int id) {
        Optional<Pizza> pizza = pizzaRepository.findById(id);

        if (pizza.isEmpty())
            return null;

        pizzaRepository.deleteById(id);
        return Optional.of(pizza.get());
    }


}
