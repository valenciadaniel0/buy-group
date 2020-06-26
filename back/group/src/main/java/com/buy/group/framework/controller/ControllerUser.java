package com.buy.group.framework.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buy.group.application.handler.command.CommandUser;
import com.buy.group.application.handler.users.HandlerCreateUser;
import com.buy.group.application.handler.users.HandlerGetUserByEmail;
import com.buy.group.application.handler.users.HandlerRecoverPassword;
import com.buy.group.application.handler.users.HandlerUpdatePassword;
import com.buy.group.application.handler.users.HandlerUpdateRecoverCode;
import com.buy.group.application.handler.users.HandlerUpdateUser;
import com.buy.group.domain.model.Role;
import com.buy.group.domain.model.User;
import com.buy.group.framework.adapter.RepositoryUserImplementation;
import com.buy.group.framework.config.JwtResponse;
import com.buy.group.framework.config.JwtTokenUtil;
import com.buy.group.framework.entity.EntityUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class ControllerUser {
    private HandlerCreateUser handlerCreateUser;
    private HandlerGetUserByEmail handlerGetUserByEmail;
    private HandlerUpdatePassword handlerUpdatePassword;
    private HandlerUpdateUser handlerUpdateUser;
    private HandlerUpdateRecoverCode handlerUpdateRecoverCode;
    private HandlerRecoverPassword handlerRecoverPassword;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private RepositoryUserImplementation repositoryUserImplementation;

    public ControllerUser(HandlerCreateUser handlerCreateUser, HandlerGetUserByEmail handlerGetUserByEmail,
            HandlerUpdatePassword handlerUpdatePassword, HandlerUpdateUser handlerUpdateUser,
            HandlerUpdateRecoverCode handlerUpdateRecoverCode, HandlerRecoverPassword handlerRecoverPassword) {
        this.handlerCreateUser = handlerCreateUser;
        this.handlerGetUserByEmail = handlerGetUserByEmail;
        this.handlerUpdatePassword = handlerUpdatePassword;
        this.handlerUpdateUser = handlerUpdateUser;
        this.handlerUpdateRecoverCode = handlerUpdateRecoverCode;
        this.handlerRecoverPassword = handlerRecoverPassword;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity createAuthenticationToken(@RequestBody CommandUser commandUser) throws Exception {
        authenticate(commandUser.getEmail(), commandUser.getPassword());
        final UserDetails userDetails = repositoryUserImplementation.loadUserByUsername(commandUser.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);
        User user = this.handlerGetUserByEmail.run(commandUser.getEmail());
        List<String> roles = new ArrayList<>();

        for (Role role : user.getRoles()) {
            roles.add(role.getName());
        }
        return ResponseEntity.ok(new JwtResponse(token, user.getEmail(), user.getName(), user.getDeviceToken(),
                user.getUsername(), roles));
    }

    @PostMapping(value = "/set-recover-code")
    public void updateRecoverCode(@RequestBody CommandUser commandUser) {
        this.handlerUpdateRecoverCode.run(commandUser.getEmail());
    }

    @PutMapping(value = "")
    public void update(@RequestBody CommandUser commandUser) {
        this.handlerUpdateUser.run(commandUser);
    }

    @PostMapping(value = "/recover-password")
    public void updatePassword(@RequestBody CommandUser commandUser) {
        User user = this.handlerGetUserByEmail.run(commandUser.getEmail());
        this.handlerRecoverPassword.run(user, commandUser.getRecoverCode());
    }

    @GetMapping("/get-by-email")
    public User getUserByEmail(@RequestBody CommandUser commandUser) {
        return this.handlerGetUserByEmail.run(commandUser.getEmail());
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