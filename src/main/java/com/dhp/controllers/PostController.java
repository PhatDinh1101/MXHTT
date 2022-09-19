/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.controllers;

import com.dhp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author LAPTOP MSI
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:messages.properties")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private Environment env;

    @RequestMapping("/post")
    public String list() {
        return "post";
    }

    @GetMapping("/post/{postId}")
    public String postDetail(Model model, @PathVariable(value = "postId") int id) {
        model.addAttribute("post", this.postService.getPostById(id));
        model.addAttribute("userWinner", this.postService.getUserwinnerPyPostId(id));
        return "detail";
    }
}
