/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.controllers;

import com.dhp.pojo.Comment;
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
 * @author LAPTOP MSI
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/{postId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable(value = "postId") int id) {
        return new ResponseEntity<>(this.postService.getComments(id), HttpStatus.OK);
    }

    @PostMapping(path = "/post/{postId}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params, HttpSession session) {
        String comment = params.get("comment");
        int postId = Integer.parseInt(params.get("postId"));
        User UserID = (User) session.getAttribute("currentUser");
        Comment c = this.postService.addComment(comment, postId, UserID);
        return new ResponseEntity<>(c, HttpStatus.CREATED);
    }
}
