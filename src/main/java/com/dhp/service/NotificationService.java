/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.service;

import com.dhp.pojo.Notifications;
import java.util.List;

/**
 *
 * @author hoang
 */
public interface NotificationService {
    Notifications addNoti(int userId, String msg);
    List<Notifications> getNoti(int userId);
}
