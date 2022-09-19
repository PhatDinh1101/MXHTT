/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dhp.repository;

import com.dhp.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LAPTOP MSI
 */
public interface UserRepository {
    boolean addUser(User user);
    List<User> getUsers(String username);
    List<User> getUsersByName(Map<String, String> name);
    
    List<User> getListUser(int page);
    int countUser();
    
    User getUserById(int id);
}
