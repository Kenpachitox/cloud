package com.example.users.controller;

import com.example.users.entity.User;
import com.example.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    private final Log logger = LogFactory.getLog(this.getClass());

    @GetMapping("/users")
    public List<User> endpoint(@RequestHeader Optional<String> authorization) {
        logger.info("Request on users");
        return service.getUsers();
    }

    @PostMapping("/users/list")
    public List<User> endpoint(@RequestBody LinkedList<Long> usersId) {
        logger.info("Request on users by id");
        return service.getUsers(usersId);
    }


}
