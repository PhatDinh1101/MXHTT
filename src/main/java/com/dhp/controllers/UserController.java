/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.controllers;

import com.dhp.pojo.User;
import com.dhp.service.PostService;
import com.dhp.service.ReportService;
import com.dhp.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author LAPTOP MSI
 */
@Controller
public class UserController {
    @Autowired
    private UserService userDetailsService;
    @Autowired
    private PostService postService;
    @Autowired
    private ReportService reportService;
    
    @ModelAttribute
    public void commomAttrs(Model model, HttpSession session) {
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/reportprofile")
    public String reports() {
        return "report";
    }

    @RequestMapping("/profile")
    public String profile() {
        return "profile";
    }
    @GetMapping("/profile/{userId}")
    public String profileDetail(Model model, @PathVariable(value = "userId") int id) {
        model.addAttribute("user", this.userDetailsService.getUserById(id));
        model.addAttribute("post", this.postService.getPostByUserId(id));
        return "profile";
    }
    @GetMapping("/profile/{userId}/reports")
    public String profileDetailReports(Model model, @PathVariable(value = "userId") int id) {
        model.addAttribute("user", this.userDetailsService.getUserById(id));
        return "profileDetailReports";
    }
    
    @GetMapping("/profile/{userId}/chatting")
    public String userChatting(Model model, @PathVariable(value = "userId") int id, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        if(id == u.getId())
            return "chat";
        return "profile";
    }
    
    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";
        if (user.getPassword().equals(user.getConfirmPassword()))
        {
            if (this.userDetailsService.addUser(user) == true) {
                return "redirect:/login";
            }
            else
                errMsg = "Da co loi xay ra";
        }
        else
            errMsg = "Mat khau khong khop";
        
        model.addAttribute("errMsg", errMsg);
        
        return "register";
    }
}
