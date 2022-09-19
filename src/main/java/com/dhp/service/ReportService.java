/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dhp.service;

import com.dhp.pojo.Report;
import com.dhp.pojo.User;
import java.util.List;

/**
 *
 * @author LAPTOP MSI
 */
public interface ReportService {
    List<Report> getReports(int userId);
    Report addReport(String report, int userWinnerId,User user);
    List<Report> getListReports();
}
