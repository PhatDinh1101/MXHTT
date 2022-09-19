/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.controllers;

import com.dhp.pojo.Auction;
import com.dhp.pojo.User;
import com.dhp.service.PostService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
public class ApiAuctionController {
    
    @Autowired
    private PostService postService;
    
    @GetMapping("/post/{postId}/auctions")
    public ResponseEntity<List<Auction>> getAuctions(@PathVariable(value = "postId") int id) {
        return new ResponseEntity<>(this.postService.getAuctions(id), HttpStatus.OK);
    }
    
    @GetMapping("/post/{postId}/auctions/guest")
    public ResponseEntity<List<Auction>> getAuctionsForGuest(@PathVariable(value = "postId") int id, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        int userId = user.getId();
        return new ResponseEntity<>(this.postService.getAuctionsForGuest(id, userId), HttpStatus.OK);
    }
    
    @PostMapping(path = "/post/{postId}/auctions", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Auction> addAuction(@RequestBody Map<String, String> params, HttpSession session) {
        try {
            String price = params.get("price");
            int postId = Integer.parseInt(params.get("postId"));
            User UserID = (User) session.getAttribute("currentUser");
            Auction c = this.postService.addAuction(price, postId, UserID);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
