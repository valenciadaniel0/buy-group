package com.buy.group.framework.controller;

import java.util.ArrayList;
import java.util.List;

import com.buy.group.application.handler.command.CommandUser;
import com.buy.group.application.handler.users.HandlerCreateUser;
import com.buy.group.application.handler.users.HandlerGetUserByEmail;
import com.buy.group.domain.model.User;
import com.buy.group.framework.adapter.RepositoryUserImplementation;
import com.buy.group.framework.config.JwtResponse;
import com.buy.group.framework.config.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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
    private HandlerGetUserByEmail handlerGetUserByEmail;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    

    @Autowired
    private RepositoryUserImplementation repositoryUserImplementation;

    public ControllerUser(HandlerCreateUser handlerCreateUser, HandlerGetUserByEmail handlerGetUserByEmail) {
        this.handlerCreateUser = handlerCreateUser;
        this.handlerGetUserByEmail = handlerGetUserByEmail;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity createAuthenticationToken(@RequestBody CommandUser userCommand) throws Exception {

        authenticate(userCommand.getUsername(), userCommand.getPassword());

        final UserDetails userDetails = repositoryUserImplementation.loadUserByUsername(userCommand.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping(value = "/register")
    public void create(@RequestBody CommandUser commandUser) {
        this.handlerCreateUser.run(commandUser);
    }

    @GetMapping("/get-by-email")
    public User getByEmail(@RequestBody CommandUser commandUser) {
        System.out.println(commandUser.getEmail());
        return this.handlerGetUserByEmail.run(commandUser.getEmail());
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}