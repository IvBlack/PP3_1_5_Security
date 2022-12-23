package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class ManagerRestController {
    private final UserService userService;

    @Autowired
    public ManagerRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //возвращает юзера из БД по имени
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getByUserName(id);
    }

    @PostMapping
    public HttpStatus addNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return HttpStatus.CREATED;
    }

    //принимает объект юзера
    //возвращает статус 200, если update успешен
    @PutMapping
    public HttpStatus updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteUser(@PathVariable String id) {
        userService.deleteById(userService.getByUserName(id).getId());
        return HttpStatus.OK;
    }
}
