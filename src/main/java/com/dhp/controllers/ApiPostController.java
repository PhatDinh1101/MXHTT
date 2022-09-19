/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dhp.pojo.Post;
import com.dhp.pojo.User;
import com.dhp.service.PostService;
import com.dhp.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author hoang
 */
@RestController
@RequestMapping("/api")
public class ApiPostController {

    @Autowired(required = true)
    private PostService postService;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private UserService userService;

    @PostMapping(path = "/postPost",
            produces = {MediaType.APPLICATION_JSON_VALUE
            }, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Post> addPost(@RequestPart(value = "content") String content,
            @RequestPart(value = "topic") String topic,
            @RequestPart(value = "file") MultipartFile file,
             HttpSession session) {
        try {

            String cont = content;
            String im;
            if (file != null) {
                Map r = this.cloudinary.uploader().upload(file.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                im = (String) r.get("secure_url");
            } else {
                im = "";
            }
            String top = topic;
            User UserID = (User) session.getAttribute("currentUser");
//            User UserID = (User) this.userService.getUsers("dat").get(0);

            Post p = this.postService.addPost(cont, im, top, UserID);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
