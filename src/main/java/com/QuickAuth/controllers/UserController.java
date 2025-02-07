package com.QuickAuth.controllers;

import com.QuickAuth.DTOs.UserDTO;
import com.QuickAuth.interfaces.IUserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final IUserServices userServices;

    public UserController(IUserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        UserDTO createdUserDTO = userServices.createUser(userDTO);

        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable int id) {
        userServices.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
