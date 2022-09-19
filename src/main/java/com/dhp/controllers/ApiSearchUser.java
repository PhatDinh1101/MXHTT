/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.controllers;

import com.dhp.pojo.User;
import com.dhp.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hoang
 */
@RestController
@RequestMapping("/api")
public class ApiSearchUser {
    @Autowired
    private UserService userDetailsService;
    
    @PostMapping(path = "/search/user", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<User>> searchUser(
            @RequestBody Map<String, String> params
    ){
        return new ResponseEntity<>(this.userDetailsService.getUsersByName(params), HttpStatus.OK);
    }
}
