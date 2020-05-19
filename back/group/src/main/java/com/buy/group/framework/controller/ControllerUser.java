package com.buy.group.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buy.group.application.handler.command.CommandUser;
import com.buy.group.application.handler.users.HandlerCreateUser;
import com.buy.group.framework.adapter.RepositoryUserImplementation;
import com.buy.group.framework.config.JwtResponse;
import com.buy.group.framework.config.JwtTokenUtil;
import com.buy.group.framework.entity.EntityUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class ControllerUser {
    private HandlerCreateUser handlerCreateUser;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RepositoryUserImplementation repositoryUserImplementation;

    public ControllerUser(HandlerCreateUser handlerCreateUser) {
        this.handlerCreateUser = handlerCreateUser;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity createAuthenticationToken(@RequestBody CommandUser commandUser) {
        final EntityUser userDetails = repositoryUserImplementation.loadUserByUsername(commandUser.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token, userDetails.getEmail(), userDetails.getName(),
                userDetails.getDeviceToken(), userDetails.getUsername(), userDetails.getRoles()));
    }

    @GetMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {            
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }        
    }

    @PostMapping(value = "/register")
    public void create(@RequestBody CommandUser commandUser) {
        this.handlerCreateUser.run(commandUser);
    }
}