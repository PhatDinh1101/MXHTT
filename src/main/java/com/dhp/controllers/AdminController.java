/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.controllers;

import com.dhp.service.PostService;
import com.dhp.service.ReportService;
import com.dhp.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author LAPTOP MSI
 */
@Controller
@RequestMapping("/admin")
@PropertySource("classpath:messages.properties")
public class AdminController {
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReportService reportService;
    @Autowired
    private Environment env;

    @GetMapping("/manager")
    public String list(Model model,
            @RequestParam Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("user", this.userService.getListUser(page));
        model.addAttribute("countUser", this.userService.countUser());
        model.addAttribute("postCounter", this.postService.countPost());
        model.addAttribute("pageSize", Integer.parseInt(env.getProperty("pageUser.size")));
        return "admin";
    }
    
    @GetMapping("/stats")
    public String stats(Model model) {
        model.addAttribute("postStats", this.postService.countPostByUser());
        return "stats";
    }
    
    @GetMapping("/postStats")
    public String postStats(Model model,
            @RequestParam(required = false) Map<String, String> params ) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = null;
        String from = params.getOrDefault("fromDate", null);
        if (from != null) 
            fromDate = f.parse(from);
        
        Date toDate = null;
        String to = params.getOrDefault("toDate", null);
        if (from != null) 
            toDate = f.parse(to);
        model.addAttribute("postStatsByDay", this.postService.postStats(fromDate, toDate));
        return "post-stats";
    }
    
    @GetMapping("/reports")
    public String report(Model model) {
//        model.addAttribute("report", this.reportService.getReports(0));
        model.addAttribute("report", this.reportService.getListReports());
        return "report";
    } 
}
