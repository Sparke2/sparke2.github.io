package com.rebrova.pizzaproject.controller;

import com.rebrova.pizzaproject.exeption.UserNotFoundException;
import com.rebrova.pizzaproject.model.User;
import com.rebrova.pizzaproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    String add(@RequestBody User user) {
        userRepository.save(user);
        return "Add user";
    }

    @GetMapping("/getAll")
    List<User> getAllUser() {
        return userRepository.findAll();
    }

    @GetMapping("{id}")
    User findById(@PathVariable int id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }
    @PutMapping("{id}")
    User updateUser(@RequestBody User newUser, @PathVariable int id) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setPhone(newUser.getPhone());
                    user.setAddress(newUser.getAddress());
                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));
    }
}
