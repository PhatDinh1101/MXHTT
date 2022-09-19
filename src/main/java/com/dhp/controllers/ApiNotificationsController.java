/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.controllers;

import com.dhp.pojo.Notifications;
import com.dhp.service.NotificationService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

/**
 *
 * @author hoang
 */
@Controller
@RequestMapping("/api")
public class ApiNotificationsController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notification/{userId}")
    public ResponseEntity<List<Notifications>> getNotification(@PathVariable(value = "userId") int id) {
        return new ResponseEntity<>(this.notificationService.getNoti(id), HttpStatus.OK);
    }

    @PostMapping(path = "/notification/{userId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Notifications> addNotification(@RequestBody Map<String, String> params) {
        try {
            return new ResponseEntity<>(this.notificationService.addNoti(Integer.parseInt(params.get("userId")), params.get("msg")), HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
