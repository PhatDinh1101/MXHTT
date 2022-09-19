/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.controllers;

import com.dhp.pojo.Report;
import com.dhp.pojo.User;
import com.dhp.service.ReportService;
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
public class ApiReportController {
    
    @Autowired
    private ReportService reportService;
    
    @GetMapping("/profile/{userId}/reports")
    public ResponseEntity<List<Report>> getReport(@PathVariable(value = "userId") int id) {
        return new ResponseEntity<>(this.reportService.getReports(id), HttpStatus.OK);
    }
    @PostMapping(path = "/profile/{userId}/reports", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Report> addReport(@RequestBody Map<String, String> params, HttpSession session){
        String content = params.get("content");
        int userId = Integer.parseInt(params.get("userReport"));
        User UserID = (User) session.getAttribute("currentUser");
        Report r = this.reportService.addReport(content, userId, UserID);
        return new ResponseEntity<>(r, HttpStatus.CREATED);
    }
}
