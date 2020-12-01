package com.acm.ws.acmplatformws.ui.controller;

import com.acm.ws.acmplatformws.ui.model.response.User;
import com.acm.ws.acmplatformws.ui.model.resquest.UserDetailsRequestModel;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "5") int page,
                          @RequestParam(value = "limit" , defaultValue = "10") int limit){
        return "getUser was called with page = " + page + " and limit = " + limit;
    }

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable String userId){
        User user = new User();
        user.setEducationLevel("IA3.2");
        user.setEmail("seghairtarek@gmail.com");
        user.setHandle("code__forces");
        user.setTelephoneNumber("22 225 303");
        user.setUserID(userId);
        user.setLastName("Seghair");
        user.setFirstName("Tarek");
        return user;
    }

    @PostMapping
    public  User createUser(@RequestBody UserDetailsRequestModel userDetailsRequestModel){
        User user = new User();
        user.setEducationLevel(userDetailsRequestModel.getEducationLevel());
        user.setEmail(userDetailsRequestModel.getEmail());
        user.setHandle(userDetailsRequestModel.getHandle());
        user.setTelephoneNumber(userDetailsRequestModel.getTelephoneNumber());
        user.setLastName(userDetailsRequestModel.getLastName());
        user.setFirstName(userDetailsRequestModel.getFirstName());
        return user;
    }

    @DeleteMapping
    public String deleteUser(){
        return "deleteUser was called";
    }

    @PutMapping
    public String updateUser(){
        return "updateUser was called";
    }
}
