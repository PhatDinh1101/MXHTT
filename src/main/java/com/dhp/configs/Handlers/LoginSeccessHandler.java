/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dhp.configs.Handlers;

import com.dhp.service.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.dhp.pojo.User;

/**
 *
 * @author hoang
 */
@Component
public class LoginSeccessHandler implements AuthenticationSuccessHandler{
    @Autowired
    private UserService UserService;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse reponse, Authentication a) throws IOException, ServletException {
        
        User u = this.UserService.getUsers(a.getName()).get(0);
        request.getSession().setAttribute("currentUser", u);
        
        reponse.sendRedirect("/BTL");
    }
    
}
