package com.buy.group.framework.controller;

import com.buy.group.application.handler.command.CommandUser;
import com.buy.group.application.handler.users.HandlerCreateUser;
import com.buy.group.framework.adapter.RepositoryUserImplementation;
import com.buy.group.framework.config.JwtResponse;
import com.buy.group.framework.config.JwtTokenUtil;
import com.buy.group.framework.entity.EntityUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @PostMapping(value = "/register")
    public void create(@RequestBody CommandUser commandUser) {
        this.handlerCreateUser.run(commandUser);
    }
}