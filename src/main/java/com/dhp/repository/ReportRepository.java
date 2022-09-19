/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dhp.repository;

import com.dhp.pojo.Report;
import com.dhp.pojo.User;
import com.dhp.pojo.Userwinner;
import java.util.List;

/**
 *
 * @author LAPTOP MSI
 */
public interface ReportRepository {

    Userwinner getUserwinner(int id);

    List<Report> getReports(int userId);

    List<Report> getListReports();

    Report addReport(String report, int userWinnerId, User user);
}
