package com.example.project.Controller;

import com.example.project.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users/{uid}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers(@PathVariable("uid") Integer uid) {
        return new ResponseEntity<Object>(userService.getUser(uid), HttpStatus.OK);
    }
}
