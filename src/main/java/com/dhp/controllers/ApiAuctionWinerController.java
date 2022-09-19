/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.controllers;

import com.dhp.pojo.User;
import com.dhp.pojo.Userwinner;
import com.dhp.service.PostService;
import com.dhp.service.UserService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hoang
 */
@RestController
@RequestMapping("/api")
public class ApiAuctionWinerController {
    
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;
    
    @GetMapping("/post/{postId}/auctionWinner")
    public ResponseEntity<List<Userwinner>> getAuctionWinner(@PathVariable(value = "postId") int id) {
        return new ResponseEntity<>(this.postService.getAuctionWinner(id), HttpStatus.OK);
    }
    
    
    @PostMapping(path = "/post/{postId}/auctionWinner", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Userwinner> addAuction(@RequestBody Map<String, String> params, HttpSession session) {
        try {
            String price = params.get("price");
            String email = params.get("email");
            int postId = Integer.parseInt(params.get("postId"));
            int userId = Integer.parseInt(params.get("userId"));
            User u = new User();
            u = this.userService.getUserById(userId);
            Userwinner c = this.postService.addAuctionWinner(price, postId, u);
            String msg = SendMail(email, "Chúc mừng đấu giá thành công", "Sản phẩm mà bạn đấu giá đã thành công");
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    
    public String SendMail(String to, String subject, String msg) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("letuandat20201@gmail.com");
        message.setTo("letuandat20201@gmail.com");
        message.setSubject(subject);
        message.setText(msg);
        mailSender.send(message);
        
        return msg;
    }
}
