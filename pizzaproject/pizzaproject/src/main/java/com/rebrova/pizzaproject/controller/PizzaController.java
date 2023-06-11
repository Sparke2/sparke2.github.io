package com.rebrova.pizzaproject.controller;

import com.rebrova.pizzaproject.model.Pizza;
import com.rebrova.pizzaproject.exeption.PizzaNotFoundException;
import com.rebrova.pizzaproject.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
@CrossOrigin
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaService;

    @PostMapping("/add")
    String add(@RequestBody Pizza pizza) {
        pizzaService.save(pizza);
        return "Add pizza";
    }

    @GetMapping("/getAll")
    List<Pizza> getAllPizza() {
        return pizzaService.findAll();
    }

    @GetMapping("{id}")
    Pizza findById(@PathVariable int id) {
        return pizzaService.findById(id)
                .orElseThrow(()-> new PizzaNotFoundException(id));
    }
    @PutMapping("{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    Pizza updatePizza(@RequestBody Pizza newPizza, @PathVariable int id) {
        return pizzaService.findById(id)
                .map(pizza -> {
                    pizza.setName(newPizza.getName());
                    pizza.setPrice(newPizza.getPrice());
                    return pizzaService.save(pizza);
                }).orElseThrow(()->new PizzaNotFoundException(id));
    }

    @DeleteMapping("{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    String delete(@PathVariable int id) {
        if(!pizzaService.existsById(id)){
            throw new PizzaNotFoundException(id);
        }
        pizzaService.deleteById(id);
        return "Pizza with id "+id+" has been deleted success";
    }
}
