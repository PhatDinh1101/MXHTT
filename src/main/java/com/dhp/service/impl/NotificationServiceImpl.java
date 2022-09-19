/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.service.impl;

import com.dhp.pojo.Notifications;
import com.dhp.repository.NotificationReponsitory;
import com.dhp.service.NotificationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hoang
 */
@Service
public class NotificationServiceImpl implements NotificationService{
    
    @Autowired
    private NotificationReponsitory notificationReponsitory;

    @Override
    public Notifications addNoti(int userId, String msg) {
        return this.notificationReponsitory.addNoti(userId, msg);
    }

    @Override
    public List<Notifications> getNoti(int userId) {
        return this.notificationReponsitory.getNoti(userId);
    }
    
}
