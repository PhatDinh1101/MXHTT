/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.service.impl;

import com.dhp.pojo.Report;
import com.dhp.pojo.User;
import com.dhp.repository.ReportRepository;
import com.dhp.service.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LAPTOP MSI
 */
@Service
public class ReportServiceImpl implements ReportService{
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report addReport(String report, int userWinnerId, User user) {
        return this.reportRepository.addReport(report, userWinnerId, user);
    }

    @Override
    public List<Report> getReports(int userId) {
        return this.reportRepository.getReports(userId);
    }

    @Override
    public List<Report> getListReports() {
        return this.reportRepository.getListReports();
    }

   
    
}
