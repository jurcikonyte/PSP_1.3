package com.user.web.controller;

import com.impl.EmailValidator;
import com.impl.PasswordChecker;
import com.impl.PhoneValidator;
import com.user.web.model.User;
import com.user.web.Exception.ValidationException;
import com.user.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    UserService service;

    EmailValidator emailValidator = new EmailValidator("","");
    PhoneValidator phoneValidator = new PhoneValidator();
    PasswordChecker passwordChecker = new PasswordChecker(2,"");

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId) {
        return service.findById(userId);
    }

    @PostMapping("/users")
    public User registerUser(@RequestBody User user) throws ValidationException {
        validateUser(user);
        return service.add(user);
    }

    @PostMapping("/users/{userId}")
    public User updateUserById(@PathVariable int userId, @RequestBody User userInfo) throws ValidationException {
        if (!service.existsById(userId)) {
            throw new ValidationException(String.format("User with id '%s' does not exist", userId));
        }
        validateUser(userInfo);
        userInfo.setId(userId);
        return service.update(userInfo);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUserById(@PathVariable int userId) {
        service.deleteById(userId);
    }

    private void validateUser(User user) throws ValidationException {
        if (user == null) {
            throw new ValidationException("User cannot be null");
        }
        if (!emailValidator.validateEmail(user.getEmail())) {
            throw new ValidationException("User email is not valid");
        }
        if (!phoneValidator.validatePhoneNumber(user.getPhoneNumber())) {
            throw new ValidationException("User phone number is not valid");
        }
        if (!passwordChecker.validatePassword(user.getPassword())) {
            throw new ValidationException("User phone number is not valid");
        }
    }
}
